package net.devstudy.resume.annotation.constraints;

import net.devstudy.resume.validator.AdulthoodConstraintValidator;

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
@Constraint(validatedBy = { AdulthoodConstraintValidator.class })
public @interface Adulthood {

	String message() default "Adulthood";
	
	int adulthoodAge() default 18;
	
	Class<? extends Payload>[] payload() default { };
	
	Class<?>[] groups() default { };
}
