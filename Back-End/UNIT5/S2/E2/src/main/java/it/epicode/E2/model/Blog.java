package it.epicode.E2.model;


import lombok.Data;

import java.time.LocalTime;

@Data
public class Blog {

    private int id;
    private static int count;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLETTURA;


    public Blog(String categoria, String titolo, String cover, String contenuto, int tempoDiLETTURA) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.cover = cover;
        this.contenuto = contenuto;
        this.tempoDiLETTURA = tempoDiLETTURA;
        count++;
        id = count;
    }
}
