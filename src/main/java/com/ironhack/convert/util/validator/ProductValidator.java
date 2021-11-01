package com.ironhack.convert.util.validator;

import com.ironhack.convert.util.validator.anotations.ValidProduct;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ProductValidator implements ConstraintValidator<ValidProduct, String> {

  private final List<String> validProduct = List.of("HYBRID", "FLATBED", "BOX");

  @Override
  public void initialize(ValidProduct product) {
  }

  @Override
  public boolean isValid(String product, ConstraintValidatorContext constraintValidatorContext) {
    if (product == null) return true;
    if (product.isBlank()) return true; // It just checks if it exists.
    return validProduct.contains(product.trim().toUpperCase());
  }

}
