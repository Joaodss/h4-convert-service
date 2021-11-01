package com.ironhack.convert.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewContactDTO {
  private String name;
  private String phoneNumber;
  private String email;
  private String companyName;
  private Long salesRepId;
  private Long accountId;


  // ---------- Custom constructor from LeadDTO ----------
  public NewContactDTO(LeadDTO leadDTO, Long accountId) {
    this.name = leadDTO.getName();
    this.phoneNumber = leadDTO.getPhoneNumber();
    this.email = leadDTO.getEmail();
    this.companyName = leadDTO.getCompanyName();
    this.salesRepId = leadDTO.getSalesRep();
    this.accountId = accountId;
  }
}
