package com.ironhack.convert.util.validator;

import com.ironhack.convert.dto.LeadConvertDTO;
import com.ironhack.convert.proxy.AccountProxy;
import com.ironhack.convert.util.validator.anotations.IsDefinedAccount;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsDefinedAccountValidator implements ConstraintValidator<IsDefinedAccount, LeadConvertDTO> {
  private final AccountProxy accountProxy;

  public IsDefinedAccountValidator(AccountProxy accountProxy) {
    this.accountProxy = accountProxy;
  }

  @Override
  public void initialize(IsDefinedAccount constraintAnnotation) {
  }

  @Override
  public boolean isValid(LeadConvertDTO leadConvertDTO, ConstraintValidatorContext constraintValidatorContext) {
    if (leadConvertDTO.getAccountId() != null)
      try {
        accountProxy.findById(leadConvertDTO.getAccountId()); // Check if id is valid
        return true;
      } catch (Exception ignored) {
        // Log stuff.
      }
    return !leadConvertDTO.getIndustry().trim().equals("") // If account id does not exist it requires an account body.
        && leadConvertDTO.getEmployeeCount() != null
        && !leadConvertDTO.getCountry().trim().equals("")
        && !leadConvertDTO.getCity().trim().equals("");
  }

}
