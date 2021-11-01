package com.ironhack.convert.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.ironhack.convert.util.EnumConverter.toCountry;
import static com.ironhack.convert.util.EnumConverter.toEnum;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountDTO {
  private Long id;
  private String industry;
  private Integer employeeCount;
  private String city;
  private String country;


  // ---------- Custom constructor from LeadConvertDTO ----------
  public AccountDTO(LeadConvertDTO leadConvertDTO) {
    this.id = 0L;
    this.industry = toEnum(leadConvertDTO.getIndustry()); ;
    this.employeeCount = leadConvertDTO.getEmployeeCount();
    this.city = leadConvertDTO.getCity();
    this.country = toCountry(leadConvertDTO.getCountry());
  }

}
