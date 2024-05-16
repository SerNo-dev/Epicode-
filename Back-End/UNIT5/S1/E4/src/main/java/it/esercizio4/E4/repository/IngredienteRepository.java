package it.esercizio4.E4.repository;

import it.esercizio4.E4.bean.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
}
