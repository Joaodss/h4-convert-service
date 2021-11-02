package com.ironhack.convert.controller;

import com.ironhack.convert.dto.ConvertInformationDTO;
import com.ironhack.convert.dto.LeadConvertDTO;
import com.ironhack.convert.dto.OpportunityDTO;
import com.ironhack.convert.service.ConvertLeadService;
import com.ironhack.convert.service.ConvertOpportunityStatusService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/convert")
public class ConvertControllerImpl implements ConvertController {
  private final ConvertLeadService convertLeadService;
  private final ConvertOpportunityStatusService convertOpportunityStatusService;

  // ---------- Constructor Dependency Injection ----------
  public ConvertControllerImpl(ConvertLeadService convertLeadService, ConvertOpportunityStatusService convertOpportunityStatusService) {
    this.convertLeadService = convertLeadService;
    this.convertOpportunityStatusService = convertOpportunityStatusService;
  }

  @PostMapping("/lead/{id}")
  @ResponseStatus(OK)
  public ConvertInformationDTO convertLead(@PathVariable("id") long leadId, @Valid @RequestBody LeadConvertDTO leadConvertDTO) {
    try {
      return convertLeadService.convertLead(leadId, leadConvertDTO);
    } catch (NoSuchElementException e1) {
      throw new ResponseStatusException(NOT_FOUND, e1.getMessage());
    } catch (Exception e) {
      throw new ResponseStatusException(INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

  @PutMapping("/opportunity/{id}/{status}")
  @ResponseStatus(OK)
  public OpportunityDTO convertOpportunityStatus(@PathVariable("id") long opportunityId, @PathVariable("status") String status) {
    try {
      return convertOpportunityStatusService.changeStatus(opportunityId, status);
    } catch (NoSuchElementException e1) {
      throw new ResponseStatusException(NOT_FOUND, e1.getMessage());
    } catch (IllegalArgumentException e2) {
      throw new ResponseStatusException(BAD_REQUEST, e2.getMessage());
    } catch (Exception e) {
      throw new ResponseStatusException(INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

}
