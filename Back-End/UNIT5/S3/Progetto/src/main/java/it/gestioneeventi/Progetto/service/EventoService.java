package it.gestioneeventi.Progetto.service;

import it.gestioneeventi.Progetto.Dto.EventDto;
import it.gestioneeventi.Progetto.entity.Evento;
import it.gestioneeventi.Progetto.entity.User;
import it.gestioneeventi.Progetto.exception.NoAvailableSeatsException;
import it.gestioneeventi.Progetto.exception.NotFoundException;
import it.gestioneeventi.Progetto.repository.EventRepository;
import it.gestioneeventi.Progetto.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EventoService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    public Evento createEvent(EventDto eventDto) {
        Evento event = new Evento();
        event.setTitolo(eventDto.getTitolo());
        event.setDescrizione(eventDto.getDescrizione());
        event.setData(eventDto.getData());
        event.setLuogo(eventDto.getLuogo());
        event.setNumeroPosti(eventDto.getNumeroPosti());
        return eventRepository.save(event);
    }

    public Evento getEventById(Integer eventId) {
        Optional<Evento> optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isPresent()) {
            return optionalEvent.get();
        } else {
            throw new NotFoundException("Event with id=" + eventId + " not found");
        }
    }

    public Evento updateEvent(Integer eventId, EventDto eventDto) {
        Optional<Evento> optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isPresent()) {
            Evento event = optionalEvent.get();
            event.setTitolo(eventDto.getTitolo());
            event.setDescrizione(eventDto.getDescrizione());
            event.setData(eventDto.getData());
            event.setLuogo(eventDto.getLuogo());
            event.setNumeroPosti(eventDto.getNumeroPosti());
            return eventRepository.save(event);
        } else {
            throw new NotFoundException("Event with id=" + eventId + " not found");
        }
    }

    public void deleteEvent(Integer eventId) {
        if (eventRepository.existsById(eventId)) {
            eventRepository.deleteById(eventId);
        } else {
            throw new NotFoundException("Event with id=" + eventId + " not found");
        }
    }

    public List<Evento> getAllEvents() {
        return eventRepository.findAll();
    }




    public void bookEvent(Integer eventId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            System.out.println("User is not authenticated");
            throw new SecurityException("User not authenticated");
        }

        String userEmail = authentication.getName();
        System.out.println("Authenticated user email: " + userEmail);

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new NotFoundException("Utente con email " + userEmail + " non trovato"));

        Evento evento = eventRepository.findById(eventId)
                .orElseThrow(() -> new NotFoundException("Evento con ID " + eventId + " non trovato"));

        if (evento.getNumeroPosti() <= 0) {
            throw new NoAvailableSeatsException("Non ci sono posti disponibili per l'evento con ID " + eventId);
        }

        evento.setNumeroPosti(evento.getNumeroPosti() - 1);
        evento.getPartecipanti().add(user);

        eventRepository.save(evento);
        System.out.println("Booking completed successfully for event ID: " + eventId);
    }

    public Set<Evento> getAttendedEventsByUserId(Integer userId) {
        return eventRepository.findAttendedEventsByUserId(userId);
    }

    public void cancelAttendance(Integer eventId, Integer userId) {
        Evento evento = eventRepository.findById(eventId)
                .orElseThrow(() -> new NotFoundException("Evento con ID " + eventId + " non trovato"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Utente con ID " + userId + " non trovato"));

        if (!evento.getPartecipanti().contains(user)) {
            throw new NotFoundException("L'utente non ha prenotato questo evento");
        }

        evento.getPartecipanti().remove(user);
        eventRepository.save(evento);
    }


}
