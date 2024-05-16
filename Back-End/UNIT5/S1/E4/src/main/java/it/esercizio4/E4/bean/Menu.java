package it.esercizio4.E4.bean;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Entity
@Component  // cosi spring già crea i automatico il bean Menu senza doverlo mettere in appconfig, e prende i vari oggetti in autowired di appconfig, cosi generiamo il menu senza far nulla solamente con 4 righe e prendendo i bean dei vari ingredienti ect
public class Menu {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "menu",fetch = FetchType.EAGER)
    private List<Bevanda> bevande;

    @OneToMany(mappedBy = "menu",fetch = FetchType.EAGER)
    private List<Ingrediente> ingredienti;

    @OneToMany(mappedBy = "menu",fetch = FetchType.EAGER)
    private List<Pizza> pizze;

    public void stampaMenu(){
        System.out.println("Menu");
        System.out.println("Bevande");
        bevande.forEach(bevanda -> System.out.println(bevanda.getNome() + " ml " + bevanda.getMl()+
                "   Kcal: " + bevanda.getCalorie() + "   prezzo: " + bevanda.getPrezzo()));

        System.out.println();
        System.out.println("Ingredienti");
        ingredienti.forEach(ingrediente -> System.out.println(ingrediente.getNome() +
                "   Kcal: " + ingrediente.getCalorie() + "   prezzo: " + ingrediente.getPrezzo()));

        System.out.println();
        System.out.println("Pizze");
        pizze.forEach(pizza -> System.out.println(pizza.getNome() +
                "   Kcal: " + pizza.getCalorie() + "   prezzo: " + pizza.getPrezzo()));;
    }
}
