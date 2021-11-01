package com.ironhack.convert.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.ironhack.convert.util.EnumConverter.toEnum;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewOpportunityDTO {
  private String status; // TODO - Might not be needed
  private String product;
  private Integer quantity;
  private Long decisionMaker;
  private Long accountId;
  private Long salesRepId;


  // ---------- Custom constructor from LeadConvertDTO ----------
  public NewOpportunityDTO(LeadConvertDTO leadConvertDTO, Long contactId, Long accountId, Long salesRepId) {
    this.status = "OPEN";
    this.product = toEnum(leadConvertDTO.getProduct());
    this.quantity = leadConvertDTO.getQuantity();
    this.decisionMaker = contactId;
    this.accountId = accountId;
    this.salesRepId = salesRepId;
  }

}
