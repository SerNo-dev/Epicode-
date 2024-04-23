package esercizio1;

import java.util.*;

public class esercizio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il numero delle parole");
        int N = scanner.nextInt();
           scanner.nextLine();

        Set<String> parole = new HashSet<>();
        List<String> duplicati = new ArrayList<>();

        for (int i = 1; i<=N; i++){
            System.out.println("Inserisci la parola n "+ i);
            String parola = scanner.nextLine();
            if(!parole.add(parola)){
              duplicati.add(parola);
            }
        }

        System.out.println("Parole uniche: " + parole);
        System.out.println("Numero di parole distinte " + parole.size());
        System.out.println("Parole duplicate: " + duplicati);

    }
}
