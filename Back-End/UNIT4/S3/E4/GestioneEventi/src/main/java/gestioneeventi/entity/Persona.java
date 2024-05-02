package gestioneeventi.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="persona")
public class Persona {

     @Id
    @GeneratedValue
    private int id;


     private String nome;
    private String cognome;
    private String email;
    private LocalDate datadinascita;

    private Sesso sesso;

    @OneToMany(mappedBy = "persona")
   private List<Partecipazione> ListaPartecipazioni;




    public Persona(int id, String nome, String cognome, String email, LocalDate datadinascita, Sesso sesso, List<Partecipazione> listaPartecipazioni) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.datadinascita = datadinascita;
        this.sesso = sesso;
        ListaPartecipazioni = listaPartecipazioni;
    }

    public Persona(){

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDatadinascita() {
        return datadinascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public List<Partecipazione> getListaPartecipazioni() {
        return ListaPartecipazioni;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDatadinascita(LocalDate datadinascita) {
        this.datadinascita = datadinascita;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public void setListaPartecipazioni(List<Partecipazione> listaPartecipazioni) {
        ListaPartecipazioni = listaPartecipazioni;
    }
}
