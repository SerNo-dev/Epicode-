import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci le ore lavorate Part-time");
        int ore = scanner.nextInt();

        Dipendente dipendente1 = new DipendenteFullTime(465003, 1500, new String[]{"Software", "Dirigente", "Vendite"});
        Dipendente dipendente2 = new DipendentePartTime(4425003, 0, new String[]{"Computer", "Addetto", "Vendite"}, ore); // Imposta le ore iniziali a 10
        Dipendente dipendente3 = new Dirigente(42121003, 1500, new String[]{"Mouse", "Occasionale", "Vendite"});


        double stipendio = dipendente2.calculateSalary();


        System.out.println("Stipendio Part-time " + dipendente2.getStipendio());



        Dipendente[] dipendenti = {dipendente1, dipendente2, dipendente3};

        for (int i = 0; i < dipendenti.length; i++) {
            System.out.println("Matricole = " + dipendenti[i].getMatricola());
            dipendenti[i].checkIn();
        }

        double StipendiTotali = 0;

        for (int i = 0; i< dipendenti.length  ; i++) {
            StipendiTotali += dipendenti[i].getStipendio();
        }

        System.out.println("Gli stipendi totali sono = " + StipendiTotali);


    }
}