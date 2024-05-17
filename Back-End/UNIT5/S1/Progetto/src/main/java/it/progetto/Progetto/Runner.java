package it.progetto.Progetto;

import it.progetto.Progetto.bean.Edificio;
import it.progetto.Progetto.bean.Postazione;
import it.progetto.Progetto.bean.Prenotazione;
import it.progetto.Progetto.bean.Utente;
import it.progetto.Progetto.enums.Tipo;
import it.progetto.Progetto.repository.PostazioneRepository;
import it.progetto.Progetto.service.EdificioService;
import it.progetto.Progetto.service.PostazioneService;
import it.progetto.Progetto.service.PrenotazioneService;
import it.progetto.Progetto.service.UtenteService;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@PropertySource("application.properties")
public class Runner implements CommandLineRunner {


    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PrenotazioneService prenotazioneService;


    @Override
    public void run(String... args) throws Exception {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(ProgettoApplication.class);

        Edificio edificio1 = ctx.getBean("edificio1", Edificio.class);
        edificioService.salvaEdificio(edificio1);

        Postazione postazione1 = ctx.getBean("postazione1", Postazione.class);
        postazioneService.salvaPostazione(postazione1);

        Postazione postazione2 = ctx.getBean("postazione2", Postazione.class);
        postazioneService.salvaPostazione(postazione2);

        Utente utente1 = ctx.getBean("utente1", Utente.class);
        utenteService.salvaUtente(utente1);

        Prenotazione prenotazione1 = ctx.getBean("prenotazione1", Prenotazione.class);
        prenotazioneService.salvaPrenotazione(prenotazione1);

        List<Postazione> postazioni = postazioneService.cercaPostazioni(postazione1.getTipo(), postazione1.getEdificio().getCitta());

        System.out.println("--------------------------------");

        if (postazioni.isEmpty()) {
            System.out.println("Nessuna postazione trovata per il tipo " + postazione1.getTipo() + " nella città " + postazione1.getEdificio().getCitta());
        } else {
            System.out.println("Postazioni trovate per il tipo " + postazione1.getTipo() + " nella città " + postazione1.getEdificio().getCitta() + ":");
            for (Postazione postazione : postazioni) {
                System.out.println(postazione);
            }
        }

        System.out.println("----------------------------");


//        List<Prenotazione> prenotazioniDaRimuovere = prenotazioneService.getPrenotazioni();
//        for (Prenotazione prenotazione : prenotazioniDaRimuovere) {
//            prenotazioneService.eliminaPrenotazione(prenotazione.getId());
//        }



        LocalDate dataPrenotazione = LocalDate.of(2023, 5, 10);
        Utente utente = ctx.getBean("utente1", Utente.class);
        Postazione postazione = ctx.getBean("postazione1", Postazione.class);
        try {
            prenotazioneService.effettuaPrenotazione(utente, postazione, dataPrenotazione);
        } catch (IllegalStateException e) {
            System.out.println( e.getMessage());
        }

    }
}
