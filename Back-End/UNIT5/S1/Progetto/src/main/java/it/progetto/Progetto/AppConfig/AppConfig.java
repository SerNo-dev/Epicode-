package it.progetto.Progetto.AppConfig;


import it.progetto.Progetto.bean.Edificio;
import it.progetto.Progetto.bean.Postazione;
import it.progetto.Progetto.bean.Prenotazione;
import it.progetto.Progetto.bean.Utente;
import it.progetto.Progetto.enums.Tipo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class AppConfig {


    @Bean("edificio1")
    public Edificio edificio() {
        Edificio edificio = new Edificio();
        edificio.setNome("Centro Innovazione TechHub");
        edificio.setIndirizzo("Via Manhattan, 10178");
        edificio.setCitta("New York");
        return edificio;
    }

    @Bean("postazione1")
    public Postazione postazione1() {
        Postazione postazione = new Postazione();
        postazione.setDescrizione("La postazione A1 si trova al secondo piano dell'edificio principale.");
        postazione.setTipo(Tipo.OPENSPACE);
        postazione.setMaxOccupanti(5);
        postazione.setEdificio(edificio());
        return postazione;
    }

    @Bean("postazione2")
    public Postazione postazione2() {
        Postazione postazione = new Postazione();
        postazione.setDescrizione("La postazione A5 si trova al primo piano dell'ala ovest.");
        postazione.setTipo(Tipo.PRIVATO);
        postazione.setMaxOccupanti(8);
        postazione.setEdificio(edificio());
        return postazione;
    }

    @Bean("utente1")
    public Utente utente1() {
        Utente utente = new Utente();
        utente.setUsername("mario.rossi");
        utente.setNomeCompleto("Mario Rossi");
        utente.setEmail("marioRossi@email.it");
        return utente;
    }

    @Bean("prenotazione1")
    public Prenotazione prenotazione1() {
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDataPrenotazione(LocalDate.of(2023, 5, 10));
        prenotazione.setPostazione(postazione1());
        prenotazione.setUtente(utente1());
        return prenotazione;
    }

    @Bean("prenotazione2")
    public Prenotazione prenotazione2() {
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDataPrenotazione(LocalDate.of(2025, 6, 11));
        prenotazione.setPostazione(postazione2());
        prenotazione.setUtente(utente1());
        return prenotazione;
    }





}
