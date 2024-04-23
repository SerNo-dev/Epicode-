package Esercizio3;

public class UsaRubrica {
    public static void main(String[] args) {

        Rubrica rubrica = new Rubrica();

        rubrica.inserisciContatto("carla","1232342");
        rubrica.inserisciContatto("Franca Galli","3445443534");
        rubrica.inserisciContatto("Mario Rossi","332453434");

        System.out.println(rubrica);

        System.out.println(rubrica.cercaPerNome("Mario Rossi"));

        System.out.println(  rubrica.cercaPerTelefono("3445443534"));

        rubrica.rimuoviContatto("Mario Rossi");

        System.out.println(rubrica);

    }
}
