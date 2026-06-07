
import services.DemoPlayer;

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
            case 2 -> System.out.println("Non ancora ..");
            case 0 -> System.out.println("Chiusura player.");
            default -> System.out.println("Scelta non valida.");
        }
    }
}








