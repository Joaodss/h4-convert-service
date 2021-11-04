package com.ironhack.convert.service;

import com.ironhack.convert.dto.OpportunityDTO;
import com.ironhack.convert.proxy.OpportunityProxy;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

import static com.ironhack.convert.util.EnumConverter.toStatus;

@Service
public class ConvertOpportunityStatusServiceImpl implements ConvertOpportunityStatusService {
  private final OpportunityProxy opportunityProxy;

  // ---------- Constructor Dependency Injection ----------
  public ConvertOpportunityStatusServiceImpl(OpportunityProxy opportunityProxy) {
    this.opportunityProxy = opportunityProxy;
  }


  // -------------------- Service Methods --------------------
  public OpportunityDTO changeStatus(long id, String status) {
    OpportunityDTO storedOpportunity = opportunityProxy.getById(id);
    if (storedOpportunity == null) throw new NoSuchElementException("Id not found.");

    String enumStatus = toStatus(status); // Will throw error if status not valid.
    return storedOpportunity.getStatus().equals(enumStatus) ?
        storedOpportunity :
        opportunityProxy.changeStatus(id, enumStatus);
  }

}
