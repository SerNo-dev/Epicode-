package it.epicode.E2.Dto;

import it.epicode.E2.model.AutoreBlog;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.time.DurationMax;


@Data
public class BlogPostDto {


    private String categoria;

    @NotNull
    private String titolo;

    private String cover;
    @NotNull
    private String contenuto;

    private int tempoDiLettura;

    @NotNull
    private int autoreId;
}
