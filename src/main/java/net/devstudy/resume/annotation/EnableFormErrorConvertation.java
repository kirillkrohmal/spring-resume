package net.devstudy.resume.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Target({ TYPE })
@Retention(RUNTIME)
@Documented
public @interface EnableFormErrorConvertation {

	String formName();
	
	String fieldReference();
	
	Class<? extends Annotation> validationAnnotationClass();
	
	@Target({ TYPE })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		EnableFormErrorConvertation[] value();
	}
}
