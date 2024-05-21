package it.epicode.E2.controller;


import it.epicode.E2.exception.AutoreNonTrovatoException;
import it.epicode.E2.model.AutoreBlog;
import it.epicode.E2.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveAutore(@RequestBody AutoreBlog autore) {
        return autoreService.saveAutore(autore);
    }

    @GetMapping("/authors")
    public List<AutoreBlog> getAutori() {
        return autoreService.getAutori();
    }

    @GetMapping("/authors/{id}")
    public AutoreBlog getAutore(@PathVariable int id) throws AutoreNonTrovatoException {
       Optional<AutoreBlog> autoreOpt = autoreService.getAutoreById(id);
       if(autoreOpt.isPresent()) {
           return autoreOpt.get();
       } else{
           throw new AutoreNonTrovatoException("Autore con id " + id + " non trovato   ");
       }
    }

    @PutMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AutoreBlog updateAutore(@PathVariable int id, @RequestBody AutoreBlog autore) throws AutoreNonTrovatoException{
        return autoreService.updateAutore(id, autore);
    }

    @DeleteMapping("/authors/{id}")
    public String deleteAutore(@PathVariable int id) throws AutoreNonTrovatoException {
     return autoreService.deleteAutore(id);
    }
}
