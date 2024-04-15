package it;
import java.util.Arrays;
import java.util.Scanner;

public class Esercizio1 {

    public static void main(String[] args) {


        moltiplicazione(5,6);
        concatena("Ciao Bello",10);

        String[] parole = popolaArray(new String[]{"ciao","bello","di","papà","!"},"cane");

        System.out.println(Arrays.toString(parole));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci la prima parola");
        String Parola1 = scanner.next();

        System.out.println("Inserisci la seconda parola");
        String Parola2 = scanner.next();

        System.out.println("Inserisci la terza parola");
        String Parola3 = scanner.next();


        System.out.println(concatenazione(Parola1,Parola2,Parola3));



        System.out.println(Perimetro(10,20));

        System.out.println(pariDispari(11));


        System.out.println("Inserisci il primo lato");
        double lato1 = scanner.nextDouble();

        System.out.println("Inserisci il secondo lato");
        double lato2 = scanner.nextDouble();

        System.out.println("Inserisci il terzo lato");
        double lato3 = scanner.nextDouble();


        System.out.println(AreaTriangolo(lato1,lato2,lato3));

    }

    public static int moltiplicazione(int a,int b){
        int c = a *b;
        return c;
    }

    public static void concatena(String s,int a){
        System.out.println(s + a);
    }

    public static String[] popolaArray(String[] lettere,String elemento){
        String[] nuovoArray = new String[lettere.length + 1];

        nuovoArray[0] = lettere[0];
        nuovoArray[1] = lettere[1];
        nuovoArray[2] = elemento;
        nuovoArray[3] = lettere[2];
        nuovoArray[4] = lettere[3];
        nuovoArray[5] = lettere[4];


        return nuovoArray;
    }

    public static String concatenazione(String Parola1,String Parola2,String Parola3){
        return Parola1 + Parola2 + Parola3;
    }

    public static int Perimetro(int numero1,int numero2){
        int somma = numero1 + numero2;

        return somma * 2;
    }

    public static int pariDispari(int numero){
        if(numero%2 == 0){
            return 0;
        } else {
            return 1;
        }
    }


    public  static double AreaTriangolo(double a, double b, double c){

        double p = (a + b + c )/2;
        return Math.sqrt(p * (p-a) * (p-b) * (p-c));
    }
}
