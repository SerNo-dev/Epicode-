package it.progetto.Progetto.repository;

import it.progetto.Progetto.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepository  extends JpaRepository<Dipendente,Integer> {
}
