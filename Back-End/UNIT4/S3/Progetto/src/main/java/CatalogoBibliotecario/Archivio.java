package CatalogoBibliotecario;

import CatalogoBibliotecario.dao.LibriRivisteDao;
import CatalogoBibliotecario.dao.PrestitoDao;
import CatalogoBibliotecario.dao.UtenteDao;
import CatalogoBibliotecario.entity.*;
import CatalogoBibliotecario.enums.Periodicita;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Archivio {

 public static void main(String[] args) {
  EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogobibliografico");
  EntityManager em = emf.createEntityManager();

  LibriRivisteDao libirivisteDao = new LibriRivisteDao(em);
  PrestitoDao prestitoDao = new PrestitoDao(em);
  UtenteDao utenteDao = new UtenteDao(em);




     String codiceISBNLibro = "ISBN-" + UUID.randomUUID().toString().substring(0, 6);

     Libri libro1 = new Libri();
     libro1.setTitolo("La Marcia");
     libro1.setGenere("Guerra");
     libro1.setAutore("Pippo");
    libro1.setCodiceISBN(codiceISBNLibro);
     libro1.setNumeroPagine(200);
     libro1.setAnnoPubblicazione(LocalDate.of(1992,2,9));

   libirivisteDao.save(libro1);

     String codiceISBNRivista = "ISBN-" + UUID.randomUUID().toString().substring(0, 6);
     Riviste rivista1 = new Riviste();
     rivista1.setTitolo("Il Giornale");
     rivista1.setPeriodicita(Periodicita.SETTIMANALE);
    rivista1.setCodiceISBN(codiceISBNRivista);
     rivista1.setNumeroPagine(50);
     rivista1.setAnnoPubblicazione(LocalDate.of(2023, 1, 1));


     libirivisteDao.save(rivista1);

     Utente utente1 = new Utente();
     utente1.setCognome("Stilton");
     utente1.setNome("Geronimo");
     utente1.setDataDiNascita(LocalDate.of(1997,5,4));
     utente1.setNumeroTessera("XL5343J");

     utenteDao.save(utente1);
     Prestito prestito1 = new Prestito();
    prestito1.setDataInizioPrestito(LocalDate.of(2025,2,9));
    prestito1.setElementoPrestato(libro1);
    prestito1.setUtente(utente1);
    prestito1.setDataRestituzioneEffettiva(LocalDate.of(2025,2,21));
    prestitoDao.save(prestito1);



    //  libirivisteDao.deleteByCodiceISBN("ISBN-027edd");


     String codiceISBN = "ISBN-123456"; // Codice ISBN da cercare
     LibriRiviste RicercaPerIsbn = libirivisteDao.getByCodiceISBN("ISBN-a21d69");
     System.out.println(RicercaPerIsbn);


     LocalDate annoPubblicazioneDaCercare = LocalDate.of(1992, 2, 9);
     List<LibriRiviste> libriRivisteByAnno = libirivisteDao.getByAnnoPubblicazione(annoPubblicazioneDaCercare);
     System.out.println("Libri e riviste pubblicati nell'anno " + annoPubblicazioneDaCercare + ":");
     for (LibriRiviste lr : libriRivisteByAnno) {
         System.out.println(lr);
     }


     String autoreDaCercare = "Pippo";

     List<LibriRiviste> libriRivisteByAutore = libirivisteDao.getByAutore(autoreDaCercare);

     System.out.println("Libri e riviste dell'autore " + autoreDaCercare + ":");
     for (LibriRiviste lr : libriRivisteByAutore) {
         if (lr instanceof Libri) {
             Libri libro = (Libri) lr;
             System.out.println("Libro: " + libro.getTitolo() + ", Autore: " + libro.getAutore() + ", Genere: " + libro.getGenere());
         } else if (lr instanceof Riviste) {
             Riviste rivista = (Riviste) lr;
             System.out.println("Rivista: " + rivista.getTitolo() + ", Periodicita: " + rivista.getPeriodicita());
         }
     }

     String titoloDaCercare = "a";
     List<LibriRiviste> libriRivisteByTitolo = libirivisteDao.getByTitolo(titoloDaCercare);
     System.out.println("Libri e riviste con il titolo contenente '" + titoloDaCercare + "':");
     for (LibriRiviste lr : libriRivisteByTitolo) {
         if (lr instanceof Libri) {
             Libri libro = (Libri) lr;
             System.out.println("Libro: " + libro.getTitolo() + ", Autore: " + libro.getAutore() + ", Genere: " + libro.getGenere());
         } else if (lr instanceof Riviste) {
             Riviste rivista = (Riviste) lr;
             System.out.println("Rivista: " + rivista.getTitolo() + ", Periodicita: " + rivista.getPeriodicita());
         }
     }



     String numeroTesseraUtente = "XL5343J";
     List<LibriRiviste> inPrestitoByUtente = prestitoDao.getInPrestitoByNumeroTesseraUtente(numeroTesseraUtente);
     System.out.println("Elementi attualmente in prestito per l'utente con numero tessera " + numeroTesseraUtente + ":");
     for (LibriRiviste lr : inPrestitoByUtente) {
         System.out.println(lr);
     }




     LocalDate today = LocalDate.now();


     LocalDate dataRestituzionePrevista = today.minusDays(5);


     Prestito prestitoScaduto = new Prestito();
     prestitoScaduto.setDataInizioPrestito(LocalDate.of(2025, 1, 1));
     prestitoScaduto.setDataRestituzionePrevista(dataRestituzionePrevista);
     prestitoScaduto.setElementoPrestato(libro1);
     prestitoScaduto.setUtente(utente1);


     prestitoDao.save(prestitoScaduto);

     List<Prestito> prestitiScadutiENonRestituiti = prestitoDao.getPrestitiScadutiENonRestituiti();

     System.out.println("Prestiti scaduti e non restituiti:");
     for (Prestito prestito : prestitiScadutiENonRestituiti) {
         System.out.println(prestito);
     }


 }



}
