package it.progetto.Progetto.service;

import it.progetto.Progetto.bean.Edificio;
import it.progetto.Progetto.repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public void salvaEdificio(Edificio edificio) {
        edificioRepository.save(edificio);
    }

    public Edificio getEdificio(int id) {
        return edificioRepository.findById(id).get();
    }

    public List<Edificio> getEdifici() {
       return edificioRepository.findAll();
    }

    public void eliminaEdificio(int id) {
        edificioRepository.deleteById(id);
    }

}
