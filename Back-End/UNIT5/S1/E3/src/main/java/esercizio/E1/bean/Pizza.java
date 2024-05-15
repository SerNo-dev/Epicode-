package esercizio.E1.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Pizza {
    private String nome;
    private double prezzo;
    int calorie;
    private List<Topping> toppings;
    private List<Topping> ingredientiBase;

    public Pizza(String nome, double prezzo, List<Topping> ingredientiBase,int calorie) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.ingredientiBase = ingredientiBase;
        this.calorie = calorie;
        this.toppings = new ArrayList<>(ingredientiBase);
    }

    public Pizza(){

    }

}
