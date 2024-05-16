package it.esercizio4.E4.repository;

import it.esercizio4.E4.bean.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
