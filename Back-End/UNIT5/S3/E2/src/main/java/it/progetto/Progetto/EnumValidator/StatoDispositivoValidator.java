package it.progetto.Progetto.EnumValidator;
import it.progetto.Progetto.enums.StatoDispositivo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;


@Component
public class StatoDispositivoValidator implements ConstraintValidator<ValidStatoDispositivo, StatoDispositivo> {

    @Override
    public void initialize(ValidStatoDispositivo constraintAnnotation) {
    }

    @Override
    public boolean isValid(StatoDispositivo value, ConstraintValidatorContext context) {
         if (value == null) {
            return false;
        }
        for (StatoDispositivo stato : StatoDispositivo.values()) {
            if (stato.equals(value)) {
                return true;
            }
        }
        return false;
    }

}
