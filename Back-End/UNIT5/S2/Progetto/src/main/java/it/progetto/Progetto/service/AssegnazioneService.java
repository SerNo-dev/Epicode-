package it.progetto.Progetto.service;


import it.progetto.Progetto.model.Dipendente;
import it.progetto.Progetto.model.Dispositivo;
import it.progetto.Progetto.repository.DipendenteRepository;
import it.progetto.Progetto.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssegnazioneService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private DispositivoRepository dispositivoRepository;

    public boolean assegnaDispositivo(int dipendenteId, int dispositivoId) {
        Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(dipendenteId);
        Optional<Dispositivo> dispositivoOptional = dispositivoRepository.findById(dispositivoId);

        if (dipendenteOptional.isPresent() && dispositivoOptional.isPresent()) {
            Dipendente dipendente = dipendenteOptional.get();
            Dispositivo dispositivo = dispositivoOptional.get();


            dispositivo.setDipendente(dipendente);
            dipendente.getDispositivi().add(dispositivo);

            dipendenteRepository.save(dipendente);
            return true;
        } else {
            return false;
        }
    }
}
