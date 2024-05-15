package esercizio.E1.bean;

import lombok.Data;

@Data
public class Topping {
    private String nome;
    private Double prezzo;


    public Topping(String nome, Double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }
}
