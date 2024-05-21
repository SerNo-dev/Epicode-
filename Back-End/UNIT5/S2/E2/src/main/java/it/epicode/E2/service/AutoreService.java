package it.epicode.E2.service;


import it.epicode.E2.exception.AutoreNonTrovatoException;
import it.epicode.E2.model.AutoreBlog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {

    private List<AutoreBlog> autori = new ArrayList<>();

    public Optional<AutoreBlog> getAutoreById(int id) {
        return autori.stream().filter(autore -> autore.getId() == id).findFirst();
    }

    public List<AutoreBlog> getAutori() {
        return autori;
    }

    public String saveAutore(AutoreBlog autore) {
        autori.add(autore);
        return "Autore creato con successo";
    }

    public AutoreBlog updateAutore(int id, AutoreBlog autore) throws AutoreNonTrovatoException {
        Optional<AutoreBlog> autoreOptional = getAutoreById(id);
        if (autoreOptional.isPresent()) {
            autoreOptional.get().setNome(autore.getNome());
            autoreOptional.get().setCognome(autore.getCognome());
            return autoreOptional.get();
        } else{
            throw new AutoreNonTrovatoException("Autore non trovato");
        }
    }

    public String deleteAutore(int id) throws AutoreNonTrovatoException {
        Optional<AutoreBlog> autoreOptional = getAutoreById(id);
        if (autoreOptional.isPresent()) {
            autori.remove(autoreOptional.get());
            return "Autore eliminato con successo";
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato");
        }
    }
}
