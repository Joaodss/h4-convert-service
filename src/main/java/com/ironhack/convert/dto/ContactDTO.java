package com.ironhack.convert.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContactDTO {
  private Long id;
  private String name;
  private String phoneNumber;
  private String email;
  private String companyName;
  private Long salesRepId;
  private Long accountId;
}
