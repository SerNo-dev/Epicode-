package gestioneeventi.entity;


import javax.persistence.*;

@Entity
@Table(name="partecipazione")
public class Partecipazione {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name= "persone_id")
    private Persona persona;


    @OneToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    private Stato stato;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;



    public Partecipazione(int id, Persona persona, Evento evento, Stato stato,Location location) {
        this.id = id;
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
        this.location = location;
    }

    public Partecipazione(){

    }

    public int getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public Stato getStato() {
        return stato;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
