package it.gestioneeventi.Progetto.repository;

import it.gestioneeventi.Progetto.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface EventRepository extends JpaRepository<Evento,Integer> {

    @Query("SELECT e FROM Evento e JOIN e.partecipanti u WHERE u.id = :userId")
    Set<Evento> findAttendedEventsByUserId(Integer userId);
}
