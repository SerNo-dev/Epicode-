package es2;

import java.util.ArrayList;
import java.util.List;

public class Sezione implements Elemento{

    private List<Elemento> elementi = new ArrayList<>();

    private String nome;

    public Sezione(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}
