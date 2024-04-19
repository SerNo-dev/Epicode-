import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        Scanner scanner = new Scanner(System.in);


        Riproduzione[] playlist = new Riproduzione[5];


        for (int i = 0; i < playlist.length; i++) {
            System.out.println("Inserisci il tipo di elemento multimediale (1: Audio, 2: Immagine, 3: Video): ");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Inserisci il titolo: ");
            String titolo = scanner.nextLine();

            System.out.println("Inserisci la durata: ");
            int durata = scanner.nextInt();
            scanner.nextLine();


            switch (scelta) {
                case 1:
                    System.out.println("Inserisci il volume: ");
                    int volume = scanner.nextInt();
                    scanner.nextLine();
                    playlist[i] = new RegistrazioneAudio(ElementoMultimediale.RegistrazioneAudio, titolo, durata, volume);
                    break;
                case 2:
                    System.out.println("Inserisci la luminosità: ");
                    int luminosita = scanner.nextInt();
                    scanner.nextLine();
                    playlist[i] = new Immagine(ElementoMultimediale.Immagine, titolo, durata, luminosita);
                    break;
                case 3:
                    System.out.println("Inserisci il volume: ");
                    volume = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Inserisci la luminosità: ");
                    luminosita = scanner.nextInt();
                    scanner.nextLine();
                    playlist[i] = new Video(ElementoMultimediale.Video, titolo, durata, volume, luminosita);
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    i--; //
                    break;
            }
        }


        int scelta;
        do {
            System.out.println("Inserisci l'indice dell'oggetto da eseguire (1-5), oppure 0 per uscire:");
            scelta = scanner.nextInt();
            scanner.nextLine();

            if (scelta >= 1 && scelta <= 5) {

                playlist[scelta - 1].play();
            } else if (scelta != 0) {
                System.out.println("Indice non valido. Riprova.");
            }
        } while (scelta != 0);

        System.out.println("Fine del programma.");
    }


}