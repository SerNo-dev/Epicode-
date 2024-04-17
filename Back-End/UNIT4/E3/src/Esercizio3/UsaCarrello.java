package Esercizio3;

public class UsaCarrello {

    public static void main(String[] args) {

        Cliente cliente = new Cliente("ssddssd","ciccio","pippo","sds@live.it","20/11/2010");

        Articolo articolo1 = new Articolo("3434de","penna",25,5);
        Articolo articolo2 = new Articolo("3wee44de","computer",1000,10);
        Articolo articolo3 = new Articolo("34ewew4de","monitor",200,20);

        Articolo[] articoli = {articolo1,articolo2,articolo3};

        Carrello carrello = new Carrello(cliente,articoli);

        double prezzoTotale = carrello.getCostoTotaleArticoli();
        int numeroPezzi = carrello.getNumeroPezzi();
        System.out.println("Prezzo totale Carrello : "+ prezzoTotale);
        System.out.println("Numero pezzi : "+ numeroPezzi);

    }

}
