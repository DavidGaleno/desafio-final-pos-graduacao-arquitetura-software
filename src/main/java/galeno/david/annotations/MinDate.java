package galeno.david.annotations;

import galeno.david.validators.MinDateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MinDateValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MinDate {
    String message() default "Data deve ser depois de {value}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String value();
}