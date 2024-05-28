package it.progetto.Progetto.controller;


import it.progetto.Progetto.Dto.DispositivoDto;
import it.progetto.Progetto.exception.BadRequestException;
import it.progetto.Progetto.exception.DispositivoNontrovatoException;
import it.progetto.Progetto.model.Dispositivo;

import it.progetto.Progetto.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @PostMapping("/api/dispositivi")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveDispositivo(@RequestBody @Validated DispositivoDto dispositivoDto, BindingResult bindingResult) { // guarda che questi dati devi andare a prenderli nel body della richiesta
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce("",((s, s2) -> s+s2))); // in questo modo nello stream avremo solo stringhe,cosi avremo una stringa unica in cui abbiamo tutti gli errori
        }
        return dispositivoService.saveDispositivo(dispositivoDto);
    }


    @GetMapping("/api/dispositivi")
    public Page<Dispositivo> getAllDispositivi(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "15") int size,
                                         @RequestParam(defaultValue = "id") String sortBy) {
        return dispositivoService.getDispositivo(page, size, sortBy);
    }


    @GetMapping("/api/dispositivi/{id}")
    public Dispositivo getDispositivoById(@PathVariable int id) {
        Optional<Dispositivo> dispositivoOpt = dispositivoService.getDispotivoById(id);

        if (dispositivoOpt.isPresent()) {
            return dispositivoOpt.get();
        } else {
            throw new DispositivoNontrovatoException("Dispositivo con  id " + id + " non trovato");
        }


    }

    @PutMapping(path = "/api/dispositivi/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Dispositivo updateDispositivo(@PathVariable int id,@RequestBody @Validated DispositivoDto dispositivoDto,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce("",((s, s2) -> s+s2)));
        }
        return dispositivoService.updateDispositivo(id,dispositivoDto);
    }

    @DeleteMapping("/api/dispositivi/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteStudente(@PathVariable int id) throws DispositivoNontrovatoException{
        return dispositivoService.deleteDispositivo(id);
    }
}
