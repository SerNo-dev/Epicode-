public class SIM {

    private int NumeroDiTelefono;
    private double CreditoDisponibile;
    private String[] ultimeChiamate;

    public SIM(int numeroDiTelefono, double creditoDisponibile) {
        this.NumeroDiTelefono = numeroDiTelefono;
        this.CreditoDisponibile = creditoDisponibile;
        this.ultimeChiamate = new String[5];
    }

    public static void main(String[] args) {
        SIM sim = new SIM(322322323, 0);
        sim.stampa();


        sim.aggiungiChiamataFittizia("123456789", 10);
        sim.aggiungiChiamataFittizia("987654321", 5);

        sim.stampa();
    }

    public void stampa() {
        System.out.println("Numero di telefono: " + this.NumeroDiTelefono);
        System.out.println("Credito Disponibile: " + this.CreditoDisponibile);
        System.out.println("Ultime chiamate:");

        for (String chiamata : this.ultimeChiamate) {
            if (chiamata != null) {
                String[] infoChiamata = chiamata.split(";");
                System.out.println("Numero chiamato: " + infoChiamata[0] + ", Durata (minuti): " + infoChiamata[1]);
            }
        }
    }

    public void aggiungiChiamataFittizia(String numeroChiamato, int durataMinuti) {

        String nuovaChiamata = numeroChiamato + ";" + durataMinuti;

        for (int i = 0; i < ultimeChiamate.length - 1; i++) {
            ultimeChiamate[i] = ultimeChiamate[i + 1];
        }

        ultimeChiamate[ultimeChiamate.length - 1] = nuovaChiamata;
    }
}
