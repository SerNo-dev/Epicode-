package CatalogoBibliotecario.entity;

import CatalogoBibliotecario.enums.Periodicita;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Riviste extends LibriRiviste{
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;


    public Riviste( String codiceISBN, String titolo, LocalDate annoPubblicazione, int numeroPagine, List<Prestito> prestiti, Periodicita periodicita) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine, prestiti);
        this.periodicita = periodicita;
    }

    public Riviste() {

    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }



    @Override
    public String toString() {
        return "Riviste{" +
                "periodicita=" + periodicita +
                '}';
    }
}
