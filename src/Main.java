import entities.Audio;
import entities.Video;
import entities.Immagine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Immagine[] immagini = new Immagine[5];
        Audio[] audios = new Audio[5];
        Video[] videos = new Video[5];

        immagini[0] = new Immagine("Nebulosa di Orione", 5 );
        immagini[1] = new Immagine("Via Lattea", 4);
        immagini[2] = new Immagine("Saturno", 6);
        immagini[3] = new Immagine("Buco Nero", 3);
        immagini[4] = new Immagine("Andromeda",8);

        audios[0] = new Audio("Let Down - Radiohead", 5,5);
        audios[1] = new Audio("Video Games - Lana Del Rey", 5, 3);
        audios[2] = new Audio("Let it be - The Beatles" , 4 , 4);
        audios[3] = new Audio("The Blower's Daughter - Damien Rice", 5,5);
        audios[4] = new Audio("High - James Blunt", 4, 2);

        videos[0] = new Video("Apollo 11" , 4, 3, 5);
        videos[1] = new Video("Missione su Marte", 3,4,4);
        videos[2] = new Video("Sistema Solare", 5,2,6);
        videos[3] = new Video("Stazione Spaziale",2,5,3);
        videos[4] = new Video("Galassia",6,3,7);

        System.out.println("Benvenuto nel Player Multimediale!");
        System.out.println("Vuoi guardare un'immagine o un video?");
        System.out.println("Oppure vuoi solo ascoltare qualcosa?");
        System.out.println("1 - Immagine");
        System.out.println("2 - Video");
        System.out.println("3 - Audio");
        System.out.println("0 - Esci");

        int scelta = scanner.nextInt();

        switch (scelta){
            case 1 -> {
                System.out.println("Hai scelto Immagine!");
                System.out.println("Scegli un numero da 1 a 5 e ti mostrerò l'immagine corrispondente!");

                for (int i = 0; i<immagini.length; i++){
                    System.out.println((i + 1) + " - " + immagini[i].getTitolo());
                }

                int sceltaImmagine = scanner.nextInt();

                immagini[sceltaImmagine -1].show();
            }
            case 2 -> System.out.println("Hai scelto Video!");
            case 3 -> System.out.println("Hai scelto Audio!");
            case 0 -> System.out.println("Chiusura player.");
            default -> System.out.println("Scelta non valida.");
        }






    }
}
