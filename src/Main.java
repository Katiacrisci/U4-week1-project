import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Multimedia[] mediaCollection = populateMedia(scanner);

        riproduciOEsci(mediaCollection, scanner);
    }

    private static void riproduciOEsci(Multimedia[] multimedia, Scanner scanner) {
        System.out.printf("Inserisci un numero da 1 a %d per riprodurre l'n-esimo elemento corrispondente in libreria, oppure 0 per uscire.\n", multimedia.length);

        int scelta = scanner.nextInt();
        while (scelta < 0 || scelta > multimedia.length - 1) {
            System.err.printf("Valore non valido. Inserisci un valore da 1 a %d per continuare, oppure 0 per uscire.\n", multimedia.length);
            scelta = scanner.nextInt();
        }

        if (scelta == 0) {
            System.out.println("Chiusura in corso. Arrivederci");
            return;
        }

        System.out.printf("Scelto l'elemento n° %d. Riproduzione in corso\n", scelta);
        if (multimedia[scelta] != null) {
            multimedia[scelta].esegui();
        }
        riproduciOEsci(multimedia, scanner);
    }

    private static Multimedia[] populateMedia(Scanner scanner) {
        Multimedia[] medias = new Multimedia[5];

        for (int i = 0; i < medias.length; i++) {
            System.out.println("Creazione di un contenuto multimediale");
            System.out.println("Digitare \"img\" per creare un'immagine, \"vid\" per creare un video, \"audio\" per creare una registrazione audio");

            String mediaType = scanner.nextLine();
            while (mediaType.isEmpty() || !(mediaType.equals("img") || mediaType.equals("vid") || mediaType.equals("audio"))) {
                System.err.println("Scelta non valida");
                System.out.println("Digitare \"img\" per creare un'immagine, \"vid\" per creare un video, \"audio\" per creare una registrazione audio");
                mediaType = scanner.nextLine();
            }

            switch (mediaType) {
                case "img":
                    medias[i] = creaImmagine(scanner);
                    break;
                case "vid":
                    medias[i] = creaVideo(scanner);
                    break;
                case "audio":
                    medias[i] = creaAudio(scanner);
                    break;
            }
        }
        return medias;
    }

    private static Immagine creaImmagine(Scanner scanner) {
        System.out.println("Stai creando un'immagine.");
        System.out.println("Inserisci un titolo per la tua immagine");
        String title = scanner.nextLine();
        System.out.println("Inserisci un valore maggiore di 0 per la luminosità dell'immagine");
        int luminosita = controllaMggZero(scanner);
        return new Immagine(title, luminosita);
    }

    private static Video creaVideo(Scanner scanner) {
        System.out.println("Stai creando un video");
        System.out.println("Inserisci un titolo per il tuo video");
        String title = scanner.nextLine();
        System.out.println("Inserisci un valore maggiore di 0 per la luminosità del video");
        int luminosita = controllaMggZero(scanner);
        System.out.println("Inserisci un valore maggiore di 0 per il volume del video");
        int volume = controllaMggZero(scanner);
        System.out.println("Inserisci un valore maggiore di 0 per la durata del video");
        int durata = controllaMggZero(scanner);
        return new Video(title, volume, luminosita, durata);
    }

    private static RegistrazioneAudio creaAudio(Scanner scanner) {
        System.out.println("Stai creando una registrazione audio");
        System.out.println("Inserisci un titolo per la tua registrazione audio");
        String title = scanner.nextLine();
        System.out.println("Inserisci un valore maggiore di 0 per il volume della registrazione audio");
        int volume = controllaMggZero(scanner);
        System.out.println("Inserisci un valore maggiore di 0 per la durata della registrazione audio");
        int durata = controllaMggZero(scanner);
        return new RegistrazioneAudio(title, volume, durata);
    }

    private static int controllaMggZero(Scanner scanner) {
        int valore = scanner.nextInt();
        while (valore <= 0) {
            System.err.printf("Valore %d non valido, inserisci un valore maggiore di 0\n", valore);
            valore = scanner.nextInt();
        }
        return valore;
    }


}