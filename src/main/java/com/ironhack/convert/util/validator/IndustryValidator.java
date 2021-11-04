package com.ironhack.convert.util.validator;

import com.ironhack.convert.util.validator.anotations.ValidIndustry;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class IndustryValidator implements ConstraintValidator<ValidIndustry, String> {

  private final List<String> validIndustry = Arrays.asList("PRODUCE", "ECOMMERCE", "MEDICAL", "OTHER", "MANUFACTURING");

  @Override
  public void initialize(ValidIndustry industry) {
  }

  @Override
  public boolean isValid(String industry, ConstraintValidatorContext constraintValidatorContext) {
    if (industry == null) return true;
    if (industry.trim().equals("")) return true; // It just checks if it exists.
    return validIndustry.contains(industry.trim().toUpperCase());
  }

}
