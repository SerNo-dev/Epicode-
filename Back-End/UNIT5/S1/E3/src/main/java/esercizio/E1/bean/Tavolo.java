package esercizio.E1.bean;


import esercizio.E1.enums.StatoTavolo;
import lombok.Data;

@Data
public class Tavolo {

    private int numero;
    private int copertiMassimi;
    private StatoTavolo stato;
}
