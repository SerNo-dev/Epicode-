package it.esercizio4.E4.bean;

import it.esercizio4.E4.enums.Stato;
import it.esercizio4.E4.enums.Stato;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Tavolo {
    @Id
    @GeneratedValue
    private int id;

    private int numero;
    private int maxCoperti;
    private Stato stato;
    private double coperto;

}
