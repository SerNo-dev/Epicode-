package it.progetto.Progetto.EnumValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = it.progetto.Progetto.validation.StatoDispositivoValidator.class)
public @interface ValidStatoDispositivo {
    String message() default "Stato del dispositivo non valido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}