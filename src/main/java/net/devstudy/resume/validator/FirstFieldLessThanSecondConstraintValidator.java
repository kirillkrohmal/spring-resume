package net.devstudy.resume.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class FirstFieldLessThanSecondConstraintValidator implements ConstraintValidator {
    @Override
    public void initialize(Annotation annotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}