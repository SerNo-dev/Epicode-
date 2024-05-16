package it.esercizio4.E4.bean;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Bevanda extends VoceDiMenu{

    @Id
    @GeneratedValue
    private int id;

    private int ml;
    private String nome;
    private int gradoAlcohol;

    @ManyToOne
    @JoinColumn(name="menu_id")
    private Menu menu;
}
