package it.esercizio4.E4.repository;

import it.esercizio4.E4.bean.Bevanda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BevandaRepository extends JpaRepository<Bevanda, Integer> {


    public List<Bevanda> findByNome(String nome);
}
