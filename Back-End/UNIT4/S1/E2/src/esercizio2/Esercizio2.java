package esercizio2;

import java.util.Scanner;

public class Esercizio2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserire valore intero compreso tra 0 e 3.");
        int x = scanner.nextInt();
        System.out.println(numberToString(x));

        scanner.nextLine();

        askForInput(scanner);

        System.out.println("Scrivi un numero intero, io farò il countdown.");
        int y = scanner.nextInt();
        countDown(y);
    }

    public static String numberToString(int a) {
        switch (a) {
            case 0:
                return "zero";
            case 1:
                return "uno";
            case 2:
                return "due";
            case 3:
                return "tre";
            default:
                return "Errore: prego inserire un valore intero compreso tra 0 e 3.";
        }



    }


    public static void askForInput (Scanner scanner) {
        boolean goOn = true;
        while (goOn) {
            System.out.println("Scrivi una stringa per averla suddivisa nei suoi caratteri. Per uscire scrivi \":q\"");
            String input = scanner.nextLine();
            if (input.equals(":q")) {
                System.out.println("Uscita dal programma.");
                goOn = false;
                break;
            } else {
                stringToChars(input);
            }
        }
    }

    public static void stringToChars(String input) {
        String[] chars = input.split("");
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
            if (i < chars.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void countDown (int a) {
        for (int i = a; i >= 0; i--) {
            System.out.println(i);
        }
        System.out.println("Ignition!");
    }


}
