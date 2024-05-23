package it.epicode.E2.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;


@Data
public class AutoreDto {


    @NotNull(message = "il nome non può essere null")
    @Size(min= 1,max=10)
    private String nome;
    @NotNull
    @Size(min=1,max = 30)
    private String cognome;
    @Email
    @NotNull(message = "l'email non può essere null")
    private String email;

    private LocalDate dataDiNascita;

   private String avatar;
}
