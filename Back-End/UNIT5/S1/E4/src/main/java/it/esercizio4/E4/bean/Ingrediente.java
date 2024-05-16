package it.esercizio4.E4.bean;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Ingrediente extends VoceDiMenu{

    @Id
    @GeneratedValue
    private int id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

    @ManyToOne
    @JoinColumn(name="ingrediente_id")
    private Menu menu;

}
