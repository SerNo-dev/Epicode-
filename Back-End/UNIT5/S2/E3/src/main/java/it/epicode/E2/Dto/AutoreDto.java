package it.epicode.E2.Dto;

import lombok.Data;

import java.time.LocalDate;


@Data
public class AutoreDto {

    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;

   private String avatar;
}
