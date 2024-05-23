package it.epicode.E2.repository;

import it.epicode.E2.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<Blog, Integer> {
}
