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

        immagini[0] = new Immagine("Nebulosa di Orione", 5);
        immagini[1] = new Immagine("Via Lattea", 4);
        immagini[2] = new Immagine("Saturno", 6);
        immagini[3] = new Immagine("Buco Nero", 3);
        immagini[4] = new Immagine("Andromeda", 8);

        audios[0] = new Audio("Let Down - Radiohead", 5, 5);
        audios[1] = new Audio("Video Games - Lana Del Rey", 5, 3);
        audios[2] = new Audio("Let it be - The Beatles", 4, 4);
        audios[3] = new Audio("The Blower's Daughter - Damien Rice", 5, 5);
        audios[4] = new Audio("High - James Blunt", 4, 2);

        videos[0] = new Video("Apollo 11", 4, 3, 5);
        videos[1] = new Video("Missione su Marte", 3, 4, 4);
        videos[2] = new Video("Sistema Solare", 5, 2, 6);
        videos[3] = new Video("Stazione Spaziale", 2, 5, 3);
        videos[4] = new Video("Galassia", 6, 3, 7);

        int scelta;

        do {
            System.out.println("Benvenuto nel Player Multimediale!");
            System.out.println("Vuoi guardare un'immagine o un video?");
            System.out.println("Oppure vuoi solo ascoltare qualcosa?");
            System.out.println("1 - Immagine");
            System.out.println("2 - Video");
            System.out.println("3 - Audio");
            System.out.println("0 - Esci");

            scelta = scanner.nextInt();

            switch (scelta) {
                case 1 -> gestisciImmagine(scanner, immagini);
                case 2 -> gestisciVideo(scanner, videos);
                case 3 -> gestisciAudio(scanner, audios);
                case 0 -> System.out.println("Chiusura player.");
                default -> System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);

    }


    public static void gestisciImmagine(Scanner scanner, Immagine[] immagini) {
        System.out.println("Hai scelto Immagine!");
        System.out.println("Scegli un numero da 1 a 5 e ti mostrerò l'immagine corrispondente!");

        for (int i = 0; i < immagini.length; i++) {
            System.out.println((i + 1) + " - " + immagini[i].getTitolo());
        }

        int sceltaImmagine = scanner.nextInt();

        immagini[sceltaImmagine - 1].show();

        Immagine immagineScelta = immagini[sceltaImmagine - 1];

        System.out.println();
        System.out.println("Luminosità attuale: " + immagineScelta.getLuminosita());
        System.out.println();
        System.out.println("Vuoi modificare la luminosità?");
        System.out.println("1 - Aumenta la luminosità");
        System.out.println("2 - Diminuisci la luminosità");
        System.out.println("0 - No");

        int sceltaLuminosita = scanner.nextInt();

        switch (sceltaLuminosita) {
            case 1 -> {
                immagineScelta.alzaLuminosita();
                System.out.println();
                System.out.println("Luminosità aumentata: " + immagineScelta.getLuminosita());
                immagineScelta.show();
            }
            case 2 -> {
                immagineScelta.abbassaLuminosita();
                System.out.println();
                System.out.println("Luminosità diminuita: " + immagineScelta.getLuminosita());
                immagineScelta.show();
            }
            case 0 -> {
                System.out.println("Nessuna modifica effettuata.");
            }
            default -> {
                System.out.println("Scelta non valida.");
            }
        }
        System.out.println();
    }


    public static void gestisciVideo(Scanner scanner, Video[] videos) {
        System.out.println("Hai scelto Video!");
        System.out.println("Scegli un numero da 1 a 5 e ti mostrerò il video corrispondente!");

        for (int i = 0; i < videos.length; i++) {
            System.out.println((i + 1) + " - " + videos[i].getTitolo());
        }

        int sceltaVideo = scanner.nextInt();

        Video videoScelto = videos[sceltaVideo - 1];

        videoScelto.play();

        System.out.println();
        System.out.println("Durata: " + videoScelto.getDurata());
        System.out.println("Volume attuale: " + videoScelto.getVolume());
        System.out.println("Luminosità attuale: " + videoScelto.getLuminosita());
        System.out.println();

        System.out.println("Vuoi modificare qualcosa?");
        System.out.println("1 - Aumenta volume");
        System.out.println("2 - Diminuisci volume");
        System.out.println("3 - Aumenta luminosità");
        System.out.println("4 - Diminuisci luminosità");
        System.out.println("0 - No");

        int sceltaModificaVideo = scanner.nextInt();

        switch (sceltaModificaVideo) {
            case 1 -> {
                videoScelto.alzaVolume();
                System.out.println("Volume aumentato: " + videoScelto.getVolume());
                System.out.println();
                videoScelto.play();
            }
            case 2 -> {
                videoScelto.abbassaVolume();
                System.out.println("Volume diminuito: " + videoScelto.getVolume());
                System.out.println();
                videoScelto.play();
            }
            case 3 -> {
                videoScelto.alzaLuminosita();
                System.out.println("Luminosità aumentata: " + videoScelto.getLuminosita());
                System.out.println();
                videoScelto.play();
            }
            case 4 -> {
                videoScelto.abbassaLuminosita();
                System.out.println("Luminosità diminuita: " + videoScelto.getLuminosita());
                System.out.println();
                videoScelto.play();
            }
            case 0 -> System.out.println("Nessuna modifica effettuata.");
            default -> System.out.println("Scelta non valida.");
        }
        System.out.println();


    }


    public static void gestisciAudio(Scanner scanner, Audio[] audios) {
        System.out.println("Hai scelto Audio!");
        System.out.println("Scegli un numero da 1 a 5 ed ascolterai l'audio corrispondente!");

        for (int i = 0; i < audios.length; i++) {
            System.out.println((i + 1) + " - " + audios[i].getTitolo());
        }

        int sceltaAudio = scanner.nextInt();

        Audio audioScelto = audios[sceltaAudio - 1];

        audioScelto.play();

        System.out.println();
        System.out.println("Durata: " + audioScelto.getDurata());
        System.out.println("Volume attuale: " + audioScelto.getVolume());
        System.out.println();

        System.out.println("Vuoi modificare qualcosa?");
        System.out.println("1 - Aumenta volume");
        System.out.println("2 - Diminuisci volume");
        System.out.println("0 - No");

        int sceltaModificaAudio = scanner.nextInt();

        switch (sceltaModificaAudio) {
            case 1 -> {
                audioScelto.alzaVolume();
                System.out.println("Volume aumentato: " + audioScelto.getVolume());
                System.out.println();
                audioScelto.play();
            }
            case 2 -> {
                audioScelto.abbassaVolume();
                System.out.println("Volume diminuito: " + audioScelto.getVolume());
                System.out.println();
                audioScelto.play();
            }
            case 0 -> System.out.println("Nessuna modifica effettuata");
            default -> System.out.println("Scelta non valida.");
        }

        System.out.println();
    }
}
