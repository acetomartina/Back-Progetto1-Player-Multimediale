
import entities.ElementoMultimediale;
import services.DemoPlayer;
import services.UserPlayer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Benvenuto nel Player Multimediale!");
        System.out.println("1 - Usa libreria demo");
        System.out.println("2 - Crea i tuoi elementi");
        System.out.println("0 - Esci");

        int sceltaIniziale = scanner.nextInt();

        switch (sceltaIniziale) {
            case 1 -> DemoPlayer.avviaDemo(scanner);
            case 2 -> {
                ElementoMultimediale[] elementi = UserPlayer.creaLibreriaPersonalizzata(scanner);
                System.out.println("Elementi creati: " + elementi.length);
                System.out.println("Vuoi visualizzarli?");
                System.out.println("1 - Sì");
                System.out.println("2 - No");

                int sceltaVisualizza = scanner.nextInt();

                if (sceltaVisualizza == 1) {
                    UserPlayer.avviaPlayer(scanner,elementi);
                } else {
                    System.out.println("Ok, chiusura player.");
                }
            }
            case 0 -> System.out.println("Chiusura player.");
            default -> System.out.println("Scelta non valida.");
        }
    }
}








