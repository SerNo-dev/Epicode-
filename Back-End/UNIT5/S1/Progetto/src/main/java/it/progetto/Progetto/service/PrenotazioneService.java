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


    public void effettuaPrenotazione(Utente utente, Postazione postazione, LocalDate dataPrenotazione) {
        List<Prenotazione> prenotazioniEsistenti = findPrenotazioniByUtenteAndDataPrenotazione(utente, dataPrenotazione);

        for (Prenotazione prenotazione : prenotazioniEsistenti) {
            if (prenotazione.getDataPrenotazione().isEqual(dataPrenotazione)) {
                System.out.println("Prenotazione trovata: " + prenotazione);
                throw new IllegalStateException("Prenotazione già effettuata per l'utente e la data specificati.");
            }
        }

        Prenotazione nuovaPrenotazione = new Prenotazione();
        nuovaPrenotazione.setDataPrenotazione(dataPrenotazione);
        nuovaPrenotazione.setPostazione(postazione);
        nuovaPrenotazione.setUtente(utente);

        salvaPrenotazione(nuovaPrenotazione);

        System.out.println("Nuova prenotazione effettuata con successo!");

    }



}
