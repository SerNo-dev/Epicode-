package it.epicode.E2.service;



import it.epicode.E2.Dto.AutoreDto;
import it.epicode.E2.exception.AutoreNonTrovatoException;
import it.epicode.E2.model.AutoreBlog;

import it.epicode.E2.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;



    public String saveAutore(AutoreDto autoreDto) {
       AutoreBlog autoreBlog = new AutoreBlog();
        autoreBlog.setNome(autoreDto.getNome());
        autoreBlog.setCognome(autoreDto.getCognome());
        autoreBlog.setDataDiNascita(autoreDto.getDataDiNascita());
        autoreBlog.setEmail(autoreDto.getEmail());
        autoreBlog.setAvatar("https://ui-avatars.com/api/?name="+autoreBlog.getNome()+"+"+autoreBlog.getCognome());
        autoreRepository.save(autoreBlog);
        return "Autore con id =" + autoreBlog.getId() + " salvato con successo";
    }


    public List<AutoreBlog> getAutori(){
        return autoreRepository.findAll();
    }

    public Optional<AutoreBlog> getAutoreByID(int id){
        return autoreRepository.findById(id);
    }

    public AutoreBlog updateAutore(int id, AutoreDto autoreDto){
        Optional<AutoreBlog> autoreOptional = getAutoreByID(id);
        if(autoreOptional.isPresent()){
            AutoreBlog autore = autoreOptional.get();
            autore.setNome(autoreDto.getNome());
            autore.setCognome(autoreDto.getCognome());
            autore.setDataDiNascita(autoreDto.getDataDiNascita());
            autore.setEmail(autoreDto.getEmail());
            autore.setAvatar("https://ui-avatars.com/api/?name="+autore.getNome()+"+"+autore.getCognome());
            autoreRepository.save(autore);
            return autore;

        } else{
            throw new AutoreNonTrovatoException("Autore con id = " + id + "non trovato");
        }

    }

    public String deleteAutore(int id){
        Optional<AutoreBlog> autoreBlogOptional = getAutoreByID(id);
        if(autoreBlogOptional.isPresent()){
            autoreRepository.delete(autoreBlogOptional.get());
            return "Autore con id = " + id + " eliminato con successo";
        } else{
            throw new AutoreNonTrovatoException("Autore con id = " + id + "non trovato");
        }
    }
 
}
