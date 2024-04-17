package Esercizio3;

public class Carrello {
    private Cliente cliente;

    private Articolo[] articoli;

    private double costoTotaleArticoli;

    private int numeroPezzi;

    public Carrello(Cliente cliente,Articolo[] articoli) {
        this.cliente = cliente;
        this.articoli = articoli;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Articolo[] getArticoli() {
        return articoli;
    }

    public int getNumeroPezzi() {
        numeroPezzi = sommaNumeriPezzi();
        return numeroPezzi;
    }

    public void setNumeroPezzi(int numeroPezzi) {
        this.numeroPezzi = numeroPezzi;
    }

    public double getCostoTotaleArticoli() {
       costoTotaleArticoli = calcolaCostoTotale();
        return costoTotaleArticoli;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setArticoli(Articolo[] articoli) {
        this.articoli = articoli;
    }

    private int sommaNumeriPezzi(){
        int somma = 0;

        for(int i = 0; i<articoli.length; i++){
            somma += articoli[i].getNumeroPezzi();
        }
        return somma;
    }


    private double calcolaCostoTotale(){
        double somma = 0;

        for(int i = 0; i<articoli.length; i++){
             somma += articoli[i].getPrezzo();

        }
        return somma;
    }
}
