package it.progetto.Progetto.service;


import it.progetto.Progetto.Dto.DispositivoDto;
import it.progetto.Progetto.exception.DispositivoNontrovatoException;
import it.progetto.Progetto.model.Dipendente;
import it.progetto.Progetto.model.Dispositivo;
import it.progetto.Progetto.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DispositivoService {


    @Autowired
    private DispositivoRepository dispositivoRepository;




    public String saveDispositivo(DispositivoDto dispositivoDto) {
        Dispositivo dispositivo = new Dispositivo();
        dispositivo.setStatoDispositivo(dispositivoDto.getStatoDispositivo());
        dispositivo.setTipologia(dispositivoDto.getTipologia());
        dispositivoRepository.save(dispositivo);

        return "Dispositivo salvato con successo";

    }
    public Page<Dispositivo> getDispositivo(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return dispositivoRepository.findAll(pageable);
    }



    public List<Dispositivo> getAllDispositivi(){
        return dispositivoRepository.findAll();
    }
    public Optional<Dispositivo> getDispotivoById(int id){
        return dispositivoRepository.findById(id);
    }



    public Dispositivo updateDispositivo(int id, DispositivoDto dispositivoDto){
        Optional<Dispositivo> dispositivoOptional = getDispotivoById(id);
        if(dispositivoOptional.isPresent()){
            Dispositivo dispositivo= dispositivoOptional.get();
            dispositivo.setTipologia(dispositivoDto.getTipologia());
            dispositivo.setStatoDispositivo(dispositivoDto.getStatoDispositivo());
            dispositivoRepository.save(dispositivo);
            return dispositivo;

        } else{
            throw new DispositivoNontrovatoException("Dispositivo con id = " +id+ "non trovato");
        }

    }

    public String deleteDispositivo(int id){
        Optional<Dispositivo> dispositivoOptional = getDispotivoById(id);
        if(dispositivoOptional.isPresent()){
            Dispositivo dispositivo = dispositivoOptional.get();
            dispositivoRepository.delete(dispositivo);
            return "Dispositivo con id = " + id + " cancellato con successo";
        } else{
            throw new DispositivoNontrovatoException("Dispositivo con id = " + id + " non trovato");
        }
    }

}
