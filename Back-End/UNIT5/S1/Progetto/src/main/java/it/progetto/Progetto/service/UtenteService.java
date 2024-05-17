package it.progetto.Progetto.service;


import it.progetto.Progetto.bean.Utente;
import it.progetto.Progetto.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public void salvaUtente(Utente utente) {
        utenteRepository.save(utente);
    }

    public Utente getUtente(int id) {
        return utenteRepository.findById(id).get();
    }

    public List<Utente> getUtenti() {
        return utenteRepository.findAll();
    }

    public void eliminaUtente(int id) {
        utenteRepository.deleteById(id);
    }
}
