package net.devstudy.resume.validator;


import net.devstudy.resume.annotation.constraints.Adulthood;

import org.joda.time.DateTime;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class AdulthoodConstraintValidator implements ConstraintValidator<Adulthood, Date> {
    private int adulthoodAge;

    @Override
    public void initialize(Adulthood constraintAnnotation) {
        adulthoodAge = constraintAnnotation.adulthoodAge();
    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        } else {
            DateTime critical = DateTime.now().minusYears(adulthoodAge);
            return value.before(critical.toDate());
        }
    }
}
