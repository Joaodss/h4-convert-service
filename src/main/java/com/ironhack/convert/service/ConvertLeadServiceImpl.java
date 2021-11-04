package com.ironhack.convert.service;

import com.ironhack.convert.dto.*;
import com.ironhack.convert.proxy.*;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static com.ironhack.convert.service.Event.*;

@Service
public class ConvertLeadServiceImpl implements ConvertLeadService {
  private final AccountProxy accountProxy;
  private final ContactProxy contactProxy;
  private final LeadProxy leadProxy;
  private final OpportunityProxy opportunityProxy;
  private final SalesRepProxy salesRepProxy;

  private Map<Event, Long> events;

  // ---------- Constructor Dependency Injection ----------
  public ConvertLeadServiceImpl(AccountProxy accountProxy, ContactProxy contactProxy, LeadProxy leadProxy, OpportunityProxy opportunityProxy, SalesRepProxy salesRepProxy) {
    this.accountProxy = accountProxy;
    this.contactProxy = contactProxy;
    this.leadProxy = leadProxy;
    this.opportunityProxy = opportunityProxy;
    this.salesRepProxy = salesRepProxy;
  }


  // -------------------- Service Methods --------------------
  public ConvertInformationDTO convertLead(long leadId, LeadConvertDTO leadConvertDTO) {
    events = new HashMap<>();
    LeadDTO leadToConvert;
    SalesRepDTO salesRepDTO;
    AccountDTO accountDTO = null;
    Long accountID = null;
    ContactDTO contactDTO;
    OpportunityDTO opportunityDTO;

    // 1. LeadId exists? Y - get Lead. N - throw error to later throw 404.
    try {
      leadToConvert = getLeadById(leadId);
    } catch (Exception e) {
      throw new NoSuchElementException("Lead id not found.");
    }

    // 2. AccountId provided in DTO? Y - does it exist? Y - associate id
    if (leadConvertDTO.getAccountId() != null) {
      try {
        accountDTO = getAccountById(leadConvertDTO.getAccountId());
        accountID = accountDTO.getId();
      } catch (Exception ignored) {
      }
    }
    // 3. Account Details provided? (must be provided if id not provided) Y - create new account, and associate id.
    if (accountID == null) {
      accountDTO = createNewAccount(new AccountDTO(leadConvertDTO));
      accountID = accountDTO.getId();
    }

    // 4. Get SalesRep information
    salesRepDTO = getSalesRepById(leadToConvert.getSalesRep());

    // 5. Create Contact
    contactDTO = createNewContact(new NewContactDTO(leadToConvert, accountID));

    // 6. Create Opportunity
    opportunityDTO = createNewOpportunity(
        new NewOpportunityDTO(leadConvertDTO, contactDTO.getId(), accountID, salesRepDTO.getId())
    );

    // 7. Delete Lead
    deleteLead(leadId);

    return new ConvertInformationDTO(salesRepDTO, accountDTO, contactDTO, opportunityDTO);
  }


  // -------------------- Aux Methods --------------------
  @Retry(name = "getLeadRetry")
  private LeadDTO getLeadById(long id) {
    return leadProxy.getLeadById(id);
  }

  @Retry(name = "getAccountRetry")
  private AccountDTO getAccountById(long id) {
    return accountProxy.findById(id);
  }

  @Retry(name = "getSalesRepRetry", fallbackMethod = "restore")
  private SalesRepDTO getSalesRepById(long id) {
    return salesRepProxy.findById(id);
  }

  @Retry(name = "createNewAccountRetry", fallbackMethod = "restore")
  private AccountDTO createNewAccount(AccountDTO accountDTO) {
    AccountDTO createdAccount = accountProxy.create(accountDTO);
    events.put(CREATE_ACCOUNT, createdAccount.getId());
    return createdAccount;
  }

  @Retry(name = "getSalesRepRetry", fallbackMethod = "restore")
  private ContactDTO createNewContact(NewContactDTO newContactDTO) {
    ContactDTO createdContact = contactProxy.store(newContactDTO);
    events.put(CREATE_CONTACT, createdContact.getId());
    return createdContact;
  }

  @Retry(name = "getSalesRepRetry", fallbackMethod = "restore")
  private OpportunityDTO createNewOpportunity(NewOpportunityDTO newOpportunityDTO) {
    OpportunityDTO createdOpportunity = opportunityProxy.createOpp(newOpportunityDTO);
    events.put(CREATE_OPPORTUNITY, createdOpportunity.getId());
    return createdOpportunity;
  }

  @Retry(name = "getSalesRepRetry", fallbackMethod = "restore")
  private void deleteLead(long id) {
    leadProxy.deleteLeadById(id);
  }


  // TODO [JA] - Ask for remaining elements. Test to check if restore is called.
  // -------------------- Fall back Methods --------------------
  private void restore() {
    for (Event key : events.keySet()) {
      switch (key) {
        case CREATE_ACCOUNT:
          accountProxy.remove(events.get(key));
//        case CREATE_CONTACT -> contactProxy.remove(events.get(key))
//        case CREATE_OPPORTUNITY -> opportunityProxy.remove(events.get(key));
      }
    }
    throw new RuntimeException("It was not possible to complete the convert request. A service must be down. Please try again later.");
  }

}

enum Event {
  CREATE_ACCOUNT,
  CREATE_CONTACT,
  CREATE_OPPORTUNITY
}
