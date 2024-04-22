package esercizio1;

import java.util.Scanner;

public class Esercizio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Scrivi una stringa, ritornerò true se è pari, altrimenti false.");
        String x = scanner.nextLine();
        System.out.println(oddEvenString(x));

        System.out.println("Scrivi il numero di un anno, verificherò se è bisestile e ritornerò true, altrimenti false.");
        int y = scanner.nextInt();
        System.out.println(leapYear(y));


    }


    public static boolean oddEvenString(String a) {
        return a.length() % 2 == 0;
    }


    public static boolean leapYear(int a) {
        if ((a % 400 == 0) || (a % 4 == 0 && a % 100 != 0)) {
            return true;
        } else {
            return false;

        }
    }

}
