package it.gestioneeventi.Progetto.Dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {

    @NotBlank(message = "il nome non può essere null o vuoto o solo spazi")
    private String name;
    @NotBlank(message = "il cognome non può essere null o vuoto o solo spazi")
    private String surname;

    @Email
    @NotBlank(message = "l'email non può essere null o vuota o solo spazi")
    private String email;

    @NotBlank(message = "La password non può essere vuota o mancante o composta da soli spazi'")
    private String password;
}
