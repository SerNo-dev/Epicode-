package it.progetto.Progetto.bean;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Prenotazione {

    @Id
    @GeneratedValue
    private int id;

    private LocalDate dataPrenotazione;


    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;


    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;


}
