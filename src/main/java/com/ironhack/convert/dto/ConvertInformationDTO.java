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
  private ContactDTO contact;
  private SalesRepDTO salesRep;
  private OpportunityDTO opportunity;
  private AccountDTO account;
}
