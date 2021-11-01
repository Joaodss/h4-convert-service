package com.ironhack.convert.util.validator.anotations;

import com.ironhack.convert.util.validator.IsDefinedAccountValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Constraint(validatedBy = IsDefinedAccountValidator.class)
@Target({TYPE})
@Retention(RUNTIME)
public @interface IsDefinedAccount {
  String message() default "Invalid account input. Account must be defined. Either by accountId or by new account properties.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
