package it.progetto.Progetto.repository;

import it.progetto.Progetto.bean.Postazione;
import it.progetto.Progetto.enums.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {

    @Query("SELECT p FROM Postazione p WHERE p.tipo = :tipo AND p.edificio.citta = :citta")
    List<Postazione> findByTipoAndCitta(Tipo tipo, String citta);
}
