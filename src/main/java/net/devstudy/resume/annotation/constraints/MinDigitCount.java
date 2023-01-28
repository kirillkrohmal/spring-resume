package net.devstudy.resume.annotation.constraints;

import net.devstudy.resume.validator.MinDigitCountConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy={MinDigitCountConstraintValidator.class})
public @interface MinDigitCount {

	int value() default 1;
	
	String message() default "MinDigitCount";
	
	Class<? extends Payload>[] payload() default { };
	
	Class<?>[] groups() default { };
}
