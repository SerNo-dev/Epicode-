package it.progetto.Progetto.service;



import it.progetto.Progetto.bean.Postazione;
import it.progetto.Progetto.bean.Prenotazione;
import it.progetto.Progetto.bean.Utente;
import it.progetto.Progetto.repository.PrenotazioneRepository;
import it.progetto.Progetto.repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void salvaPrenotazione(Prenotazione prenotazione) {
        prenotazioneRepository.save(prenotazione);
    }

    public Prenotazione getPrenotazione(int id) {
        return prenotazioneRepository.findById(id).get();
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    public void eliminaPrenotazione(int id) {
        prenotazioneRepository.deleteById(id);
    }





    public List<Prenotazione> findPrenotazioniByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione) {
        return prenotazioneRepository.findPrenotazioniByUtenteAndDataPrenotazione(utente, dataPrenotazione);
    }


     public List<Prenotazione> findPrenotazioniByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione) {
        return prenotazioneRepository.findPrenotazioniByPostazioneAndDataPrenotazione(postazione, dataPrenotazione);
    }


    

    public void effettuaPrenotazione(Utente utente, Postazione postazione, LocalDate dataPrenotazione) {

        List<Prenotazione> prenotazioniEsistentiUtente = findPrenotazioniByUtenteAndDataPrenotazione(utente, dataPrenotazione);


        if (!prenotazioniEsistentiUtente.isEmpty()) {
            throw new IllegalStateException("Prenotazione già effettuata per l'utente e la data specificati.");
        }


        List<Prenotazione> prenotazioniEsistentiPostazione = findPrenotazioniByPostazioneAndDataPrenotazione(postazione, dataPrenotazione);


        if (!prenotazioniEsistentiPostazione.isEmpty()) {
            throw new IllegalStateException("La postazione è già prenotata per la data specificata.");
        }


        Prenotazione nuovaPrenotazione = new Prenotazione();
        nuovaPrenotazione.setDataPrenotazione(dataPrenotazione);
        nuovaPrenotazione.setPostazione(postazione);
        nuovaPrenotazione.setUtente(utente);


        salvaPrenotazione(nuovaPrenotazione);


        System.out.println("Nuova prenotazione effettuata con successo!");
    }




}
