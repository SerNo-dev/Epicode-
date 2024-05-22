package it.epicode.E2.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
public class Blog {

    @Id
    @GeneratedValue
    private int id;
    // private static int count;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLETTURA;

    @ManyToOne
    @JoinColumn(name = "autore_id")
    @JsonIgnore
    private AutoreBlog autore;


//    public Blog(String categoria, String titolo, String cover, String contenuto, int tempoDiLETTURA) {
//        this.categoria = categoria;
//        this.titolo = titolo;
//        this.cover = cover;
//        this.contenuto = contenuto;
//        this.tempoDiLETTURA = tempoDiLETTURA;
//        count++;
//        id = count;
//    }
}
