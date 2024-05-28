package it.progetto.Progetto.controller;


import it.progetto.Progetto.Dto.DipendenteDto;
import it.progetto.Progetto.exception.BadRequestException;
import it.progetto.Progetto.exception.DipendenteNonTrovatoException;
import it.progetto.Progetto.model.Dipendente;
import it.progetto.Progetto.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;



    @GetMapping("/api/dipendenti")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public List<Dipendente> getDipendenti(){
        return dipendenteService.getAllDipendenti();
    }

    @GetMapping("/api/dipendenti/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER)")
    public Dipendente getDipendenteById(@PathVariable int id){
        Optional<Dipendente> dipendenteOptional = dipendenteService.getDipendenteById(id);
        if(dipendenteOptional.isPresent()){
            return dipendenteOptional.get();
        } else{
            throw new DipendenteNonTrovatoException("Dipendenti con id = " + id + " non trovato");
        }
    }

    @PutMapping("/api/dipendenti/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Dipendente updateDipendente(@PathVariable int id, @RequestBody @Validated DipendenteDto dipendenteDto,BindingResult bindingResult){
        if(bindingResult.hasErrors()){ // Se ci sono erorri nella validazione
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce("",((s, s2) -> s+s2))); // in questo modo nello stream avremo solo stringhe,cosi avremo una stringa unica in cui abbiamo tutti gli errori
        }
        return  dipendenteService.updateDipendente(id,dipendenteDto);
    }

    @DeleteMapping("/api/dipendenti/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteDipendente(@PathVariable int id){
        return dipendenteService.deleteDipendente(id);
    }

    @PatchMapping("/api/dipendenti/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String patchFotoDipendente(@RequestBody MultipartFile foto, @PathVariable int id)  throws IOException {
        return dipendenteService.patchFotoDipendente(id,foto);
    }


}
