package it.esercizio4.E4.repository;

import it.esercizio4.E4.bean.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Integer>    {

    @Query("select count(p) from Pizza p")
    public Integer findCountofPizze();
}
