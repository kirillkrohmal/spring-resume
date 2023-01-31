package net.devstudy.resume.validator;

import net.devstudy.resume.annotation.constraints.EnglishLanguage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnglishLanguageConstraintValidator implements ConstraintValidator<EnglishLanguage, String> {
    @Override
    public void initialize(EnglishLanguage englishLanguage) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
