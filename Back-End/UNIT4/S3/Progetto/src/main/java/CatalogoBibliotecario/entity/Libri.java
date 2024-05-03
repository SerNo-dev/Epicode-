package CatalogoBibliotecario.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Libri extends LibriRiviste {
     String autore;
     String genere;


    public Libri( String codiceISBN, String titolo, LocalDate annoPubblicazione, int numeroPagine, List<Prestito> prestiti, String autore, String genere) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine, prestiti);
        this.autore = autore;
        this.genere = genere;
    }

    public Libri() {

    }

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }


    @Override
    public String toString() {
        return "Libri{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
