package Archivio;

import Classi.Libri;
import Classi.LibriRiviste;
import Classi.Riviste;

import java.util.List;
import java.util.stream.Collectors;

public class Archivio {

    private List<LibriRiviste> archivio;

    public Archivio(List<LibriRiviste> archivio) {
        this.archivio = archivio;
    }

    public void aggiuntaLibro(LibriRiviste libro) {
        archivio.add(libro);
    }

    public void aggiuntaRivista(Riviste rivista) {
        archivio.add(rivista);
    }



    public void rimuoviElemento(String codiceISBN) {

        boolean elementoTrovato = archivio.stream()
                .anyMatch(elemento -> elemento.getCodiceISBN().equals(codiceISBN));

        if (elementoTrovato) {
            archivio.removeIf(elemento -> elemento.getCodiceISBN().equals(codiceISBN));
        } else {
            System.out.println("Nessun libro con il codice ISBN " + codiceISBN + " trovato nell'archivio.");
        }
    }


    public LibriRiviste ricerca(String codiceISBN) {
        List<LibriRiviste> ricercaperIsbn = archivio.stream().filter(elemento -> elemento.getCodiceISBN().equals(codiceISBN)).collect(Collectors.toList());
        return ricercaperIsbn.get(0);
    }

    public LibriRiviste ricercaPerAnno(int annoPubblicazione) {
        List<LibriRiviste>  ricercaperAnnoPubb = archivio.stream().filter(elemento -> elemento.getAnnoPubblicazione() == annoPubblicazione).collect(Collectors.toList());
      return ricercaperAnnoPubb.get(0);
    }
    public List<Libri> ricercaPerAutore(String autore) {
        List<Libri> risultato = archivio.stream()
                .filter(elemento -> elemento instanceof Libri)
                .map(elemento -> (Libri) elemento)
                .filter(libro -> libro.getAutore().equals(autore))
                .distinct()
                .collect(Collectors.toList());

        if (risultato.isEmpty()) {
            System.out.println("Nessun libro trovato per l'autore " + autore);
        }

        return risultato;
    }



    @Override
    public String toString() {
        return "Archivio{" +
                "archivio=" + archivio +
                '}';
    }
}
