package Classi;

public class Libri extends LibriRiviste {
    String autore;
    String genere;

    public Libri(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine,String autore,String genere) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
         this.autore = autore;
         this.genere = genere;

    }

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libri{" +
                "codiceISBN='" + getCodiceISBN() + '\'' +
                ", titolo='" + getTitolo() + '\'' +
                ", autore='" + getAutore() + '\'' +
                ", genere='" + getGenere() + '\'' +
                ", annoPubblicazione=" + getAnnoPubblicazione() +
                ", numeroPagine=" + getNumeroPagine() +
                '}';
    }

}
