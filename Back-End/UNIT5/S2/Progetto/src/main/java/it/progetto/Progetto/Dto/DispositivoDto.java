package it.progetto.Progetto.Dto;

import it.progetto.Progetto.EnumValidator.ValidStatoDispositivo;
import it.progetto.Progetto.enums.StatoDispositivo;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DispositivoDto {

    @NotBlank(message = "La tipologia non può essere null o vuoto o solo spazi")
    private String tipologia;



    @ValidStatoDispositivo(message="Stato dispositivo non valido")
    private StatoDispositivo statoDispositivo;
}
