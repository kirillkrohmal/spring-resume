package net.devstudy.resume.annotation.constraints;

import net.devstudy.resume.validator.MinLowerCharCountConstraintValidator;

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
@Constraint(validatedBy={MinLowerCharCountConstraintValidator.class})
public @interface MinLowerCharCount {

	int value() default 1;
	
	String message() default "MinLowerCharCount";
	
	Class<? extends Payload>[] payload() default { };
	
	Class<?>[] groups() default { };
}
