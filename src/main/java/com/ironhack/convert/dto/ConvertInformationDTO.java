package com.ironhack.convert.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConvertInformationDTO {
  private SalesRepDTO salesRep;
  private AccountDTO account;
  private ContactDTO contact;
  private OpportunityDTO opportunity;
}
