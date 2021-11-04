package com.ironhack.convert.util.validator;

import com.ironhack.convert.util.validator.anotations.ValidProduct;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class ProductValidator implements ConstraintValidator<ValidProduct, String> {

  private final List<String> validProduct = Arrays.asList("HYBRID", "FLATBED", "BOX");

  @Override
  public void initialize(ValidProduct product) {
  }

  @Override
  public boolean isValid(String product, ConstraintValidatorContext constraintValidatorContext) {
    if (product == null) return true;
    if (product.trim().equals("")) return true; // It just checks if it exists.
    return validProduct.contains(product.trim().toUpperCase());
  }

}
