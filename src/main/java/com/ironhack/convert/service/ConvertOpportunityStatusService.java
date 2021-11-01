package com.ironhack.convert.service;

import com.ironhack.convert.dto.OpportunityDTO;

public interface ConvertOpportunityStatusService {

  OpportunityDTO changeStatus(long id, String status);

}
