package com.ironhack.convert.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OpportunityDTO {
  private Long id;
  private String status;
  private String product;
  private Integer quantity;
  private Long decisionMaker;
  private Long accountId;
  private Long salesRepId;

}
