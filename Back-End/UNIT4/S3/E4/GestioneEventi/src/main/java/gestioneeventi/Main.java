package gestioneeventi;

import gestioneeventi.dao.EventoDao;
import gestioneeventi.dao.LocationDAO;
import gestioneeventi.dao.PartecipazioneDAO;
import gestioneeventi.dao.PersonaDAO;
import gestioneeventi.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

        EntityManager em = emf.createEntityManager();

        EventoDao dao = new EventoDao(em);

//       Evento evento1 = new Evento();
//
//
//       evento1.setTitolo("Carnevale");
//       evento1.setDataEvento(LocalDate.of(1990,8,6));
//       evento1.setDescrizione("Il carnevale di Venezia");
//       evento1.setTipoevento(TipoEvento.PUBBLICO);
//       evento1.setNumeroMassimoPartecipanti(100);
//
//
//      // dao.save(evento1);
//
//       Evento ev = dao.getByID(7);
//
//        System.out.println(ev);
//
//
//     //   ev.setTipoevento(TipoEvento.PRIVATO);
//
//       // dao.save(ev);
//       dao.delete(ev);



       Persona persona = new Persona();
       persona.setNome("Pippo");
       persona.setCognome("Geronimo");
       persona.setEmail("ger@live.it");
       persona.setDatadinascita(LocalDate.of(1995,02,19));
       persona.setSesso(Sesso.M);
        PersonaDAO personadao = new PersonaDAO(em);

        personadao.save(persona);


       Evento evento2 = new Evento();
        evento2.setTitolo("Tomorrowland");
        evento2.setDataEvento(LocalDate.of(2025,5,10));
        evento2.setDescrizione("Festa della Musica");
        evento2.setTipoevento(TipoEvento.PUBBLICO);
        evento2.setNumeroMassimoPartecipanti(2000);

        dao.save(evento2);


        Location location1 = new Location();

        location1.setCitta("Dubai");
        location1.setNome("Parco Della Musica");

        LocationDAO locationdao= new LocationDAO(em);
        locationdao.save(location1);


        PartecipazioneDAO partecipazionedao = new PartecipazioneDAO(em);

        Partecipazione partecipazioni = new Partecipazione();

        partecipazioni.setEvento(evento2);
        partecipazioni.setPersona(persona);
        partecipazioni.setStato(Stato.DA_CONFERMARE);
       partecipazioni.setLocation(location1);
        partecipazionedao.save(partecipazioni);



    }
}
