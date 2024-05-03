package CatalogoBibliotecario.dao;

import CatalogoBibliotecario.entity.LibriRiviste;
import CatalogoBibliotecario.entity.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class LibriRivisteDao {


    private EntityManager em;

    public LibriRivisteDao(EntityManager em) {
        this.em = em;
    }

    public void save(LibriRiviste libririviste){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(libririviste);
        et.commit();
    }

    public LibriRiviste getById(int id){
        return em.find(LibriRiviste.class,id);
    }


    public void delete(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        LibriRiviste libririviste = getById(id);

        if(libririviste != null){
            em.remove(libririviste);
        } else{
            System.out.println("Evento non presente");
        }
        et.commit();
    }

    public void deleteByCodiceISBN(String codiceISBN) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Query query = em.createQuery("SELECT lr FROM LibriRiviste lr WHERE lr.codiceISBN = :codiceISBN");
        query.setParameter("codiceISBN", codiceISBN);
        LibriRiviste libriRiviste = (LibriRiviste) query.getSingleResult();

        if (libriRiviste != null) {

            List<Prestito> prestiti = libriRiviste.getPrestiti();
            if (!prestiti.isEmpty()) {

                for (Prestito prestito : prestiti) {
                    em.remove(prestito);
                }
            }

            em.remove(libriRiviste);
        } else {
            System.out.println("LibriRiviste non trovato per il codice ISBN specificato: " + codiceISBN);
        }

        et.commit();
    }


    public LibriRiviste getByCodiceISBN(String codiceISBN) {
        Query query = em.createQuery("SELECT lr FROM LibriRiviste lr WHERE lr.codiceISBN = :codiceISBN");
        query.setParameter("codiceISBN", codiceISBN);
        return (LibriRiviste) query.getSingleResult();
    }


    public List<LibriRiviste> getByAnnoPubblicazione(LocalDate annoPubblicazione) {
        Query query = em.createQuery("SELECT lr FROM LibriRiviste lr WHERE lr.annoPubblicazione = :annoPubblicazione");
        query.setParameter("annoPubblicazione", annoPubblicazione);
        return query.getResultList();
    }

    public List<LibriRiviste> getByAutore(String autore) {
        Query query = em.createQuery("SELECT lr FROM LibriRiviste lr JOIN Libri l ON lr.id = l.id WHERE l.autore = :autore");
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    public List<LibriRiviste> getByTitolo(String titolo) {
        Query query = em.createQuery("SELECT lr FROM LibriRiviste lr WHERE lr.titolo LIKE :titolo");
        query.setParameter("titolo", "%" + titolo + "%");
        return query.getResultList();
    }



}
