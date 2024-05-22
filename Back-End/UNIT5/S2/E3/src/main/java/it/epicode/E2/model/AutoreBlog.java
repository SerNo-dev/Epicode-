package it.epicode.E2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class AutoreBlog {
    @Id
    @GeneratedValue
    private int id;
  //  private static int count;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;

    @OneToMany(mappedBy = "autore")
    private List<Blog> postsBlog;


    public AutoreBlog(String nome, String cognome, String email, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.avatar= generateAvatarLink();
    }
    public AutoreBlog() {

    }


    private String generateAvatarLink() {
        String baseUrl = "https://ui-avatars.com/api/";
        String nameParameter = "?name=" + nome.replace(" ", "+") + "+" + cognome.replace(" ", "+");
        return baseUrl + nameParameter;
    }
}
