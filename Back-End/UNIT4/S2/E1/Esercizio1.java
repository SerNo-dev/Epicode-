import java.util.Arrays;
import java.util.Scanner;

public class Esercizio1 {

    int[] numeri;

    public Esercizio1(int[] _numeri) {
        this.numeri = _numeri;

    }

    public int[] numeriCasuali() {
        for (int i = 0; i < numeri.length; i++) {
            numeri[i] = (int) (Math.random() * 10) + 1;
        }
        return numeri;
    }

    public static void main(String[] args) {


        int[] arrayDiNumeri = new int[5];
        Esercizio1 arrayNumeri = new Esercizio1(arrayDiNumeri);
        int[] numeriCasuali = arrayNumeri.numeriCasuali();
        System.out.println(Arrays.toString(numeriCasuali));

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arrayDiNumeri.length; i++) {
            System.out.println("Scegli una posizione tra : 1,2,3,4,5");
            int scelta = scanner.nextInt();

            if (scelta == 0) {
                System.out.println("Termina del programma");
                return;
            }


            if (scelta < 1 || scelta > 5) {
                System.out.println("Scelta non valida. Riprova.");
                i--;
                continue;
            }

            System.out.println("Inserisci il numero che vuoi mettere al posto della posizione precedente");
            int numero = scanner.nextInt();


            switch (scelta) {
                case 1:
                    numeriCasuali[0] = numero;
                    System.out.println(Arrays.toString(numeriCasuali));
                    break;

                case 2:
                    numeriCasuali[1] = numero;
                    System.out.println(Arrays.toString(numeriCasuali));
                    break;
                case 3:
                    numeriCasuali[2] = numero;
                    System.out.println(Arrays.toString(numeriCasuali));
                    break;
                case 4:
                    numeriCasuali[3] = numero;
                    System.out.println(Arrays.toString(numeriCasuali));
                    break;
                case 5:
                    numeriCasuali[4] = numero;
                    System.out.println(Arrays.toString(numeriCasuali));
                    break;


            }

        }


    }

}
