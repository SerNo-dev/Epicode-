package it.epicode.E2.controller;


import it.epicode.E2.Dto.AutoreDto;
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
    public String saveAutore(@RequestBody AutoreDto autoreDto) {
        return autoreService.saveAutore(autoreDto);
    }

    @GetMapping("/authors")
    public List<AutoreBlog> getAutori() {
        return autoreService.getAutori();
    }

    @GetMapping("/authors/{id}")
    public AutoreBlog getAutoreById(@PathVariable int id) {
       Optional<AutoreBlog> autoreOpt = autoreService.getAutoreByID(id);
       if(autoreOpt.isPresent()) {
           return autoreOpt.get();
       } else{
           throw new AutoreNonTrovatoException("Autore con id " + id + " non trovato   ");
       }
    }

    @PutMapping("/authors/{id}")
    public AutoreBlog updateAutore(@PathVariable int id, @RequestBody AutoreDto autoreDto) {
        return autoreService.updateAutore(id, autoreDto);
    }

    @DeleteMapping("/authors/{id}")
    public String deleteAutore(@PathVariable int id) {
     return autoreService.deleteAutore(id);
    }
}
