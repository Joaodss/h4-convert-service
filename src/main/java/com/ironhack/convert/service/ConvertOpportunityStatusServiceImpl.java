package com.ironhack.convert.service;

import com.ironhack.convert.dto.OpportunityDTO;
import com.ironhack.convert.proxy.OpportunityProxy;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

import static com.ironhack.convert.util.EnumConverter.toStatus;

@Service
public class ConvertOpportunityStatusServiceImpl implements ConvertOpportunityStatusService {
  private final OpportunityProxy opportunityProxy;

  public ConvertOpportunityStatusServiceImpl(OpportunityProxy opportunityProxy) {
    this.opportunityProxy = opportunityProxy;
  }

  public OpportunityDTO changeStatus(long id, String status) {
    if (opportunityProxy.getById(id) == null) throw new NoSuchElementException("Id not found.");
    return opportunityProxy.changeStatus(id, toStatus(status));
  }

}
