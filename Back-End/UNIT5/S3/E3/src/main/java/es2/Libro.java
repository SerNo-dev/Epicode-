package es2;

import java.util.ArrayList;
import java.util.List;

public class Libro implements Elemento{
    private String nome;
    private double prezzo;

    private List<String> autori = new ArrayList<>();
    private List<Elemento> elementi = new ArrayList<>();

    public Libro(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getPagine() {
        return elementi.stream().mapToInt(Elemento::getPagine).sum();
    }

    @Override
    public void stampa() {
        elementi.forEach(Elemento::stampa);
    }

    public void add(Elemento elemento){
        elementi.add(elemento);
    }

    public void addAutori(String autore){
        autori.add(autore);
    }
}
