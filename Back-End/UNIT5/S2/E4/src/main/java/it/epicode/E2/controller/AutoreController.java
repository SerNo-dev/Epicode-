package it.epicode.E2.controller;


import it.epicode.E2.Dto.AutoreDto;
import it.epicode.E2.exception.AutoreNonTrovatoException;
import it.epicode.E2.exception.BadRequestException;
import it.epicode.E2.model.AutoreBlog;
import it.epicode.E2.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @PostMapping("/authors")
    public String saveAutore(@RequestBody @Validated AutoreDto autoreDto, BindingResult bindingResult)  {
        if(bindingResult.hasErrors()){
        throw new BadRequestException(bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce("",((s, s2) -> s+s2)));
    }
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
    public AutoreBlog updateAutore(@PathVariable int id, @RequestBody @Validated AutoreDto autoreDto,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce("",((s, s2) -> s+s2)));
        }
        return autoreService.updateAutore(id, autoreDto);
    }

    @DeleteMapping("/authors/{id}")
    public String deleteAutore(@PathVariable int id) {
     return autoreService.deleteAutore(id);
    }
}
