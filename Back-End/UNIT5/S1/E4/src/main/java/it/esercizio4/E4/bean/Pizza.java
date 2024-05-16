package it.esercizio4.E4.bean;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Pizza extends VoceDiMenu{

    @Id
    @GeneratedValue
    private int id;
    private String nome;

    @OneToMany(mappedBy = "pizza")
    private List<Ingrediente> ingredienti;

    @ManyToOne
    @JoinColumn(name="menu_id")
    private Menu menu;
    private boolean xl;
}
