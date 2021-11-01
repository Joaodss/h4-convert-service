package com.ironhack.convert.service;

import com.ironhack.convert.dto.*;
import com.ironhack.convert.proxy.*;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ConvertLeadServiceImpl implements ConvertLeadService {
  private final AccountProxy accountProxy;
  private final ContactProxy contactProxy;
  private final LeadProxy leadProxy;
  private final OpportunityProxy opportunityProxy;
  private final SalesRepProxy salesRepProxy;

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

  public LeadDTO getLeadById(long id) {
    return leadProxy.getLeadById(id);
  }

  public AccountDTO getAccountById(long id) {
    return accountProxy.findById(id);
  }

  public SalesRepDTO getSalesRepById(long id) {
    return salesRepProxy.findById(id);
  }

  public AccountDTO createNewAccount(AccountDTO accountDTO) {
    return accountProxy.create(accountDTO);
  }

  public ContactDTO createNewContact(NewContactDTO newContactDTO) {
    return contactProxy.store(newContactDTO);
  }

  public OpportunityDTO createNewOpportunity(NewOpportunityDTO newOpportunityDTO) {
    return opportunityProxy.createOpp(newOpportunityDTO);
  }

  public LeadDTO deleteLead(long id) {
    return leadProxy.deleteLeadById(id);
  }

}
