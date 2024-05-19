package it.progetto.Progetto.repository;

import it.progetto.Progetto.bean.Postazione;
import it.progetto.Progetto.bean.Prenotazione;
import it.progetto.Progetto.bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {



    @Query("SELECT p FROM Prenotazione p WHERE p.utente = :utente AND p.dataPrenotazione = :dataPrenotazione")
    List<Prenotazione> findPrenotazioniByUtenteAndDataPrenotazione( Utente utente,LocalDate dataPrenotazione);

     @Query("SELECT p FROM Prenotazione p WHERE p.postazione = :postazione AND p.dataPrenotazione = :dataPrenotazione")
    List<Prenotazione> findPrenotazioniByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);



}
