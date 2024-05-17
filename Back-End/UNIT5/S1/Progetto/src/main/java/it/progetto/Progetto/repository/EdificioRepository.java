package it.progetto.Progetto.repository;

import it.progetto.Progetto.bean.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<Edificio, Integer> {
}
