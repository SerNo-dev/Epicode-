package Esercizio3;

public class Articolo {

    private String codice;
    private String descrizione;
    private double prezzo;
    private int numeroPezzi;

    public Articolo(String codice, String descrizione, double prezzo, int numeroPezzi) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.numeroPezzi = numeroPezzi;
    }

    public String getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public int getNumeroPezzi() {
        return numeroPezzi;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setNumeroPezzi(int numeroPezzi) {
        this.numeroPezzi = numeroPezzi;
    }
}
