package it.progetto.Progetto.bean;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Edificio {

    @Id
    @GeneratedValue
    private int id;

    private String nome;

    private String indirizzo;

    private String citta;

    @OneToMany(mappedBy = "edificio", fetch = FetchType.EAGER)
    private List<Postazione> postazioni;


    @Override
    public String toString() {
        return "Edificio{" +
                "citta='" + citta + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", nome='" + nome + '\'' +
                ", id=" + id +
                '}';
    }
}
