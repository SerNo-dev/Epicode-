package it.progetto.Progetto.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import it.progetto.Progetto.enums.StatoDispositivo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Dispositivo {

    @Id
    @GeneratedValue
    private int id;

    private String tipologia;

    @Enumerated(EnumType.STRING)
    private StatoDispositivo statoDispositivo;

    @ManyToOne
    @JoinColumn(name="dipendente_id")
    @JsonIgnore
    private Dipendente dipendente;
}
