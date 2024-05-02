package gestioneeventi.dao;

import gestioneeventi.entity.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {


    private EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(partecipazione);
        et.commit();
    }

    public Partecipazione getById(int id){
        Partecipazione partecipazione = em.find(Partecipazione.class,id);

        return partecipazione;
    }

    public void delete(Partecipazione partecipazione){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(partecipazione);
        et.commit();
    }
}
