package Archivio;

import Classi.Libri;
import Classi.LibriRiviste;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UsaArchivio {
    public static void main(String[] args) {
        List<LibriRiviste> libri = List.of(
                new Libri("X-23434-43", "Il signore degli anelli", 1954, 1170, "J.R.R. Tolkien", "fantasy"),
                new Libri("Y-56789-01", "Harry Potter e la pietra filosofale", 1997, 320, "J.K. Rowling", "fantasy"),
                new Libri("Z-12345-67", "1984", 1949, 328, "George Orwell", "distopia"),
                new Libri("W-98765-43", "Orgoglio e pregiudizio", 1823, 432, "Jane Austen", "romanzo"),
                new Libri("V-54321-09", "Cronache del ghiaccio e del fuoco: Il gioco del trono", 1996, 694, "George R.R. Martin", "fantasy"),
                new Libri("U-10987-65", "Il piccolo principe", 1943, 96, "Antoine de Saint-Exupéry", "favola")
        );

        Archivio archivio = new Archivio(new ArrayList<>(libri));
        System.out.println("Archivio iniziale:");
        System.out.println(archivio);


        try {
            archivio.aggiuntaLibro(new Libri("U-10-65", "Il caneasa", 1943, 96, "Antoine de Saint-Exupéry", "favola"));
            System.out.println("Aggiunto nuovo libro:");
            System.out.println(archivio);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: Il libro con lo stesso codice ISBN è già presente nell'archivio.");
        }


        archivio.rimuoviElemento("U-10987-65");
        archivio.rimuoviElemento("W-98765-43");
        System.out.println("Archivio dopo rimozione Libri: ");
        System.out.println(archivio);

        try {
            LibriRiviste LibroCercatoperISBN = archivio.ricerca("Z-12345-67");
            System.out.println("Libro cercato per ISBN: ");
            System.out.println(LibroCercatoperISBN);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Libro Non trovato");
        }

        try {
            LibriRiviste libroCercatoPerAnno = archivio.ricercaPerAnno(1943);
            System.out.println("Libro cercato per Anno: ");
            System.out.println(libroCercatoPerAnno);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Libro non trovato per anno");
        }

        System.out.println("Ricerca per autore: ");
        List<Libri> libriCercatiPerAutore = archivio.ricercaPerAutore("George Orwell");
        System.out.println(libriCercatiPerAutore);


        String listaLibri = libri.stream()
                .filter(libro -> libro instanceof Libri)
                .map(libro -> {
                    Libri lib = (Libri) libro;
                    return lib.getCodiceISBN() + "@" + lib.getTitolo() + "@" + lib.getAnnoPubblicazione() + "@" + lib.getNumeroPagine() + "@" + lib.getAutore() + "@" + lib.getGenere();
                })
                .collect(Collectors.joining("#"));
        System.out.println("Lista libri Stringa");
        System.out.println(listaLibri);


        File file = new File("./persitence/libri.txt");

        try {
            FileUtils.writeStringToFile(file, listaLibri, Charset.defaultCharset());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }



        List<Libri> listaLibriDaDisco = new ArrayList<>();

        try {
            String str = FileUtils.readFileToString(file,Charset.defaultCharset());

            String[] libriStr = str.split("#");


            for (String libroStr : libriStr) {

                String[] attributi = libroStr.split("@");


                if (attributi.length == 6) {

                    String codiceISBN = attributi[0];
                    String titolo = attributi[1];
                    int annoPubblicazione = Integer.parseInt(attributi[2]);
                    int numeroPagine = Integer.parseInt(attributi[3]);
                    String autore = attributi[4];
                    String genere = attributi[5];


                    Libri libro = new Libri(codiceISBN, titolo, annoPubblicazione, numeroPagine, autore, genere);
                    listaLibriDaDisco.add(libro);
                }
            }

            System.out.println("Lista libri da Disco : ");
           listaLibriDaDisco.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }

    }
}
