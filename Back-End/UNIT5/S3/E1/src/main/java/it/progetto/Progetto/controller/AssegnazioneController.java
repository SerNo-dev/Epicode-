package it.progetto.Progetto.controller;

import it.progetto.Progetto.service.AssegnazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assegna-dispositivo")
public class AssegnazioneController {

    @Autowired
    private AssegnazioneService assegnazioneService;

    @PutMapping("/{dipendenteId}/{dispositivoId}")
    public ResponseEntity<String> assegnaDispositivo(@PathVariable int dipendenteId, @PathVariable int dispositivoId) {
        boolean assegnazioneRiuscita = assegnazioneService.assegnaDispositivo(dipendenteId, dispositivoId);

        if (assegnazioneRiuscita) {
            return ResponseEntity.ok("Dispositivo assegnato correttamente al dipendente.");
        } else {
            return ResponseEntity.badRequest().body("Dipendente o dispositivo non trovato.");
        }
    }
}
