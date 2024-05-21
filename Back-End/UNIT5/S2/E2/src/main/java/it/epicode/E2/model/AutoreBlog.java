package it.epicode.E2.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AutoreBlog {

    private int id;
    private static int count;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;

    public AutoreBlog(String nome, String cognome, String email, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.avatar= generateAvatarLink();
        count++;
        id= count;
    }

    private String generateAvatarLink() {
        String baseUrl = "https://ui-avatars.com/api/";
        String nameParameter = "?name=" + nome.replace(" ", "+") + "+" + cognome.replace(" ", "+");
        return baseUrl + nameParameter;
    }
}
