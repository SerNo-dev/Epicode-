package it.gestioneeventi.Progetto.controller;


import it.gestioneeventi.Progetto.Dto.EventDto;
import it.gestioneeventi.Progetto.entity.Evento;
import it.gestioneeventi.Progetto.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/events")
public class EventController {


    @Autowired
    private EventoService eventService;

    @PostMapping
    @PreAuthorize("hasAuthority('Organizzatore_eventi')")
    public Evento createEvent(@RequestBody @Valid EventDto eventDto) {
        return eventService.createEvent(eventDto);
    }

    @GetMapping("/{eventId}")
    @PreAuthorize("hasAuthority('Organizzatore_eventi')")
    public Evento getEventById(@PathVariable Integer eventId) {
        return eventService.getEventById(eventId);
    }

    @PutMapping("/{eventId}")
    @PreAuthorize("hasAuthority('Organizzatore_eventi')")
    public Evento updateEvent(@PathVariable Integer eventId, @RequestBody @Valid EventDto eventDto) {
        return eventService.updateEvent(eventId, eventDto);
    }

    @DeleteMapping("/{eventId}")
    @PreAuthorize("hasAuthority('Organizzatore_eventi')")
    public void deleteEvent(@PathVariable Integer eventId) {
        eventService.deleteEvent(eventId);
    }

    @GetMapping
    public List<Evento> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PutMapping("/{eventId}/book")
    @PreAuthorize("hasAnyAuthority('Utente_normale', 'Organizzatore_eventi')")
    public void bookEvent(@PathVariable Integer eventId) {
        System.out.println("Received request to book event with ID: " + eventId);
        eventService.bookEvent(eventId);
    }

    @GetMapping("/user/{userId}/attended-events")
    public Set<Evento> getAttendedEvents(@PathVariable Integer userId) {
        return eventService.getAttendedEventsByUserId(userId);
    }

}
