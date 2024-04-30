package gestioneeventi;

import gestioneeventi.dao.EventoDao;
import gestioneeventi.entity.Evento;
import gestioneeventi.entity.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

        EntityManager em = emf.createEntityManager();

        EventoDao dao = new EventoDao(em);

       Evento evento1 = new Evento();


       evento1.setTitolo("Carnevale");
       evento1.setDataEvento(LocalDate.of(1990,8,6));
       evento1.setDescrizione("Il carnevale di Venezia");
       evento1.setTipoevento(TipoEvento.PUBBLICO);
       evento1.setNumeroMassimoPartecipanti(100);


      // dao.save(evento1);

       Evento ev = dao.getByID(7);

        System.out.println(ev);


        ev.setTipoevento(TipoEvento.PRIVATO);

        dao.save(ev);
      // dao.delete(ev);
    }
}
