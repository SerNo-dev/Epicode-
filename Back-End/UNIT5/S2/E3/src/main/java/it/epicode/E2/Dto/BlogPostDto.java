package it.epicode.E2.Dto;

import it.epicode.E2.model.AutoreBlog;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
public class BlogPostDto {

    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;
    private int autoreId;
}
