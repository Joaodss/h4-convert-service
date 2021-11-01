package com.ironhack.convert.controller;

import com.ironhack.convert.dto.ConvertInformationDTO;
import com.ironhack.convert.dto.LeadConvertDTO;
import com.ironhack.convert.dto.OpportunityDTO;

public interface ConvertController {

  ConvertInformationDTO convertLead(long leadId, LeadConvertDTO leadConvertDTO);

  OpportunityDTO convertOpportunityStatus(long leadId, String status);


}
