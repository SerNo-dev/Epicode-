package it.esercizio4.E4.bean;


import it.esercizio4.E4.enums.StatoOrdine;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data

public class Ordine {

    @Id
    @GeneratedValue
    private int id;

    private int numeroOrdine;
    private StatoOrdine statoOrdine;
    private int numeroCoperti;
    private LocalDateTime dataAcquisizione;
    private Tavolo tavolo;


    private List<Bevanda> bevande;
    private List<Ingrediente> ingredienti;
    private List<Pizza> pizze;

    public double prezzoTotale() {
        double totale = bevande.stream().mapToDouble(Bevanda::getPrezzo).sum();
        totale+=ingredienti.stream().mapToDouble(Ingrediente::getPrezzo).sum();
        totale+=pizze.stream().mapToDouble(Pizza::getPrezzo).sum();
        totale+= tavolo.getCoperto()*numeroCoperti;
        return totale;
    }

    public Ordine(int numeroCoperti,Tavolo tavolo) throws Exception{  // Ordine richiederà 2 argomenti cosi
     if(numeroCoperti<=tavolo.getMaxCoperti()){
         this.numeroCoperti=numeroCoperti;
         this.tavolo = tavolo;
     } else {
         throw new Exception("Numero coperti superiore al numero massimo di coperti");
     }
    }

    public void stampaOrdine(){
        System.out.println("Ordine" + numeroOrdine);
        System.out.println("Bevande");
        bevande.forEach(bevanda -> System.out.println(bevanda.getNome() + " ml " + bevanda.getMl()+
              "   prezzo: " + bevanda.getPrezzo()));

        System.out.println();
        System.out.println("Ingredienti");
        ingredienti.forEach(ingrediente -> System.out.println(ingrediente.getNome() +
                 "   prezzo: " + ingrediente.getPrezzo()));

        System.out.println();
        System.out.println("Pizze");
        pizze.forEach(pizza -> System.out.println(pizza.getNome() +
               "   prezzo: " + pizza.getPrezzo()));

        System.out.println();
        System.out.println("Prezzo totale: " + prezzoTotale());
    }
}
