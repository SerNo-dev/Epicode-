package gestioneeventi.dao;

import gestioneeventi.entity.Evento;
import gestioneeventi.entity.Location;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {
    private EntityManager em;
    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(location);
        et.commit();
    }

    public Location getByID(int id){
        Location ev = em.find(Location.class,id);
        return ev;
    }

    public void delete(Location location){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(location);
        et.commit();
    }

}
