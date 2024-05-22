package it.epicode.E2.repository;

import it.epicode.E2.model.AutoreBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoreRepository extends JpaRepository<AutoreBlog, Integer> {
}
