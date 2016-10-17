package org.javaee7.chapter06;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

/**
 * Validation Constraint for a User ID at the Acme Factory
 *
 * @author Juneau
 */
@Pattern(regexp = "[0-9]{7}[JJ]")
@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserIdValidator {

    String message() default "{invalid.userid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}