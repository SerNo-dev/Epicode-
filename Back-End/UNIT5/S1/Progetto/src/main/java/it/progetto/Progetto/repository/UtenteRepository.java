package it.progetto.Progetto.repository;

import it.progetto.Progetto.bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {
}
