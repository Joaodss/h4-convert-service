package com.ironhack.convert.service;

import com.ironhack.convert.dto.ConvertInformationDTO;
import com.ironhack.convert.dto.LeadConvertDTO;

public interface ConvertLeadService {

  ConvertInformationDTO convertLead(long leadId, LeadConvertDTO leadConvertDto);

}
