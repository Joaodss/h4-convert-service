package com.ironhack.convert.util.validator.anotations;

import com.ironhack.convert.util.validator.ProductValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Documented
@Constraint(validatedBy = ProductValidator.class)
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface ValidProduct {
  String message() default "Invalid product. Please use a valid product [HYBRID, FLATBED, BOX].";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
