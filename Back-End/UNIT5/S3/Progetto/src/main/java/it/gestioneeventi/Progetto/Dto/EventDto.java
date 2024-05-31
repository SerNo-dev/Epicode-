package it.gestioneeventi.Progetto.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EventDto {

    @NotBlank(message = "il titolo non può essere null o vuoto o solo spazi")
    private String titolo;

    private String descrizione;
    @NotNull(message = "La data non può essere null")
    private LocalDate data;

    private String luogo;
    @NotNull(message = "Il numero dei posti deve essere specificato")
    private int numeroPosti;


}
