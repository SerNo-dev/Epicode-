package CatalogoBibliotecario.entity;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Prestito {

    @Id
    @GeneratedValue
    private int id;


    @ManyToOne
    @JoinColumn(name="utente_id")
    private  Utente utente;

    @ManyToOne
    @JoinColumn(name="elementoPrestato_id")
    private LibriRiviste elementoPrestato;

    private LocalDate dataInizioPrestito;

    private LocalDate dataRestituzionePrevista;

    private LocalDate dataRestituzioneEffettiva;

    public Prestito(Utente utente, LibriRiviste elementoPrestato, LocalDate dataInizioPrestito, LocalDate dataRestituzionePrevista, LocalDate dataRestituzioneEffettiva) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = calcoloDataPrevista();
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public LocalDate calcoloDataPrevista(){
        return this.dataInizioPrestito.plusDays(30);
    }

    public Prestito(){

    }

    public Utente getUtente() {
        return utente;
    }

    public LibriRiviste getElementoPrestato() {
        return elementoPrestato;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public void setElementoPrestato(LibriRiviste elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = calcoloDataPrevista();
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }


    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", elementoPrestato=" + elementoPrestato +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}
