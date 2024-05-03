package CatalogoBibliotecario.dao;

import CatalogoBibliotecario.entity.LibriRiviste;
import CatalogoBibliotecario.entity.Prestito;
import CatalogoBibliotecario.entity.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class PrestitoDao {

    private EntityManager em;

    public PrestitoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(prestito);
        et.commit();
    }

    public Prestito getById(int id){
        return em.find(Prestito.class,id);
    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Prestito prestito = getById(id);

        if(prestito!=null){
            em.remove(prestito);
        }
        else{
            System.out.println("Persona non presente");
        }

        et.commit();

    }

    public List<LibriRiviste> getInPrestitoByNumeroTesseraUtente(String numeroTesseraUtente) {
        Query query = em.createQuery("SELECT lr FROM LibriRiviste lr JOIN lr.prestiti p WHERE p.utente.numeroTessera = :numeroTesseraUtente ");
        query.setParameter("numeroTesseraUtente", numeroTesseraUtente);
        return query.getResultList();
    }


    public List<Prestito> getPrestitiScadutiENonRestituiti() {
        LocalDate today = LocalDate.now();
        Query query = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < :today AND p.dataRestituzioneEffettiva IS NULL");
        query.setParameter("today", today);
        return query.getResultList();
    }


}
