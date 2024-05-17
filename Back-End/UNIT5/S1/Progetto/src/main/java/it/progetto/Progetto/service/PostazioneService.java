package it.progetto.Progetto.service;

import it.progetto.Progetto.bean.Postazione;
import it.progetto.Progetto.enums.Tipo;
import it.progetto.Progetto.repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public void salvaPostazione(Postazione Postazione) {
        postazioneRepository.save(Postazione);
    }

    public Postazione getPostazione(int id) {
        return postazioneRepository.findById(id).get();
    }

    public List<Postazione> getPostazioni() {
        return postazioneRepository.findAll();
    }

    public void eliminaPostazione(int id) {
        postazioneRepository.deleteById(id);
    }

    public List<Postazione> cercaPostazioni(Tipo tipo, String citta) {
        return postazioneRepository.findByTipoAndCitta(tipo, citta);
    }


}
