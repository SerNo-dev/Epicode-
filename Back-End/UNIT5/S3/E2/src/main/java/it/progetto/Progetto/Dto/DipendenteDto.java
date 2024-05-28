package it.progetto.Progetto.Dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DipendenteDto {

    @NotBlank(message="L'username non può essere null ovuoto o solo spazi")
    private String username;
    @NotBlank(message = "il nome non può essere null o vuoto o solo spazi")
    private String nome;
    @NotBlank(message = "il cognome non può essere null o vuoto o solo spazi")
    private String cognome;

    @Email
    @NotBlank(message = "l'email non può essere null o vuota o solo spazi")
    private String email;

    @NotBlank(message = "La password non può essere vuota o mancante o composta da soli spazi'")
    private String password;




}
