package com.ironhack.convert.dto;

import com.ironhack.convert.util.validator.anotations.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@IsDefinedAccount
public class LeadConvertDTO {

  @NotBlank
  @ValidProduct
  private String product;

  @NotNull
  @Positive(message = "Quantity must be positive. Please try again!")
  private Integer quantity;


  @Positive(message = "Account ID must a valid positive number. Please try again!")
  private Long accountId;


  @ValidIndustry
  private String industry;

  @Positive(message = "Employee count must be positive. Please try again!")
  private Integer employeeCount;

  @Size(max = 25, message = "Exceeds maximum value of 25 characters. Please try again.")
  @Pattern(regexp = "[a-zA-Z\\u00C0-\\u00FF]+", message = "City can not contain numbers. Please try again.")
  private String city;

  @ValidCountry
  private String country;

}
