import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Esercizio2 {
    double km;
    double litri;

    public Esercizio2(double _km,double _litri){
        this.km = _km;
        this.litri = _litri;
    }

    public double kmfatti(){
        if (litri == 0) {
            throw new ArithmeticException();
        }
       double kmpercorsi =  km / litri;
       return  kmpercorsi;
    }

    static Logger logger = LoggerFactory.getLogger("logger1");

    public static void main(String[] args) {


        logger.info("Sto lanciando l'applicazione");

        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Inserisci i km fatti");
            int km = scanner.nextInt();
            logger.info(Integer.toString(km));
            System.out.println("Inserisci i litri consumati");
            int litri = scanner.nextInt();
            Esercizio2 esercizio2 = new Esercizio2(km,litri);
            System.out.println("Hai percorso " + esercizio2.kmfatti() + "km/lt");
        } catch ( ArithmeticException e){
            System.out.println("Divisione per 0 non ammessa  ");
        }

        logger.info("Sto terminando l'applicazione");

    }
}
