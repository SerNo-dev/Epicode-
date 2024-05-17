package it.progetto.Progetto.bean;


import it.progetto.Progetto.enums.Tipo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Postazione {

    @Id
    @GeneratedValue
    private int id;

    private String descrizione;


    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private int maxOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

   @OneToMany (mappedBy = "postazione", fetch = FetchType.EAGER)
    private List<Prenotazione> prenotazioni;

    @Override
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", tipo=" + tipo +
                ", maxOccupanti=" + maxOccupanti +
                ", edificio=" + edificio +
                '}';
    }
}
