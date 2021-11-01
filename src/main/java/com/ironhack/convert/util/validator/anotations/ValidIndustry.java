package com.ironhack.convert.util.validator.anotations;

import com.ironhack.convert.util.validator.IndustryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Documented
@Constraint(validatedBy = IndustryValidator.class)
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface ValidIndustry {
  String message() default "Invalid industry. Please use a valid industry [PRODUCE, ECOMMERCE, MEDICAL, OTHER, MANUFACTURING].";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
