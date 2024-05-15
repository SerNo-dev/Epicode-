package esercizio.E1.bean;

import esercizio.E1.enums.StatoOrdine;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Ordine {


    private int numeroOrdine;
    private StatoOrdine stato;
    private int numeroCoperti;
    private LocalDateTime oraAcquisizione;
    @Autowired
    private List<Menu> menu;

    private double costoCoperto = 5.0;

    public double getPrezzoTotale() {
        double prezzoTotale = 0;


        for (Menu menu : menu) {
            prezzoTotale += calcolaPrezzoPizze(menu.getPizze());
        }


        for (Menu menu : menu) {
            prezzoTotale += calcolaPrezzoBevande(menu.getBevande());
        }


        prezzoTotale += costoCoperto * numeroCoperti;

        return prezzoTotale;
    }

    private double calcolaPrezzoPizze(List<Pizza> pizze) {
        double prezzoPizze = 0;
        for (Pizza pizza : pizze) {
            prezzoPizze += pizza.getPrezzo();
        }
        return prezzoPizze;
    }

    private double calcolaPrezzoBevande(List<Bevanda> bevande) {
        double prezzoBevande = 0;
        for (Bevanda bevanda : bevande) {
            prezzoBevande += bevanda.getPrezzo();
        }
        return prezzoBevande;
    }


}
