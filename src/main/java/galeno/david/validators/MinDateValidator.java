package galeno.david.validators;

import galeno.david.annotations.MinDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class MinDateValidator implements ConstraintValidator<MinDate, LocalDate> {

    private LocalDate minDate;

    @Override
    public void initialize(MinDate constraintAnnotation) {
        this.minDate = LocalDate.parse(constraintAnnotation.value());
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext context) {
        if (localDate == null) {
            return true;
        }

        return !localDate.isBefore(minDate);
    }
}