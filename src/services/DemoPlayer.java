package services;

import entities.Audio;
import entities.Immagine;
import entities.Video;
import entities.ElementoMultimediale;

import java.util.Scanner;

public  class DemoPlayer {
    public static ElementoMultimediale[] creaLibreriaDemo() {

        ElementoMultimediale[] elementi = new ElementoMultimediale[15];

        elementi[0] = new Immagine("Nebulosa di Orione", 5);
        elementi[1] = new Immagine("Via Lattea", 4);
        elementi[2] = new Immagine("Saturno", 6);
        elementi[3] = new Immagine("Buco Nero", 3);
        elementi[4] = new Immagine("Andromeda", 8);

        elementi[5] = new Audio("Let Down - Radiohead", 5, 5);
        elementi[6] = new Audio("Video Games - Lana Del Rey", 5, 3);
        elementi[7] = new Audio("Let it be - The Beatles", 4, 4);
        elementi[8] = new Audio("The Blower's Daughter - Damien Rice", 5, 5);
        elementi[9] = new Audio("High - James Blunt", 4, 2);

        elementi[10] = new Video("Apollo 11", 4, 3, 5);
        elementi[11] = new Video("Missione su Marte", 3, 4, 4);
        elementi[12] = new Video("Sistema Solare", 5, 2, 6);
        elementi[13] = new Video("Stazione Spaziale", 2, 5, 3);
        elementi[14] = new Video("Galassia", 6, 3, 7);

        return elementi;
    }

    public static void avviaDemo(Scanner scanner) {

        ElementoMultimediale[] elementi = creaLibreriaDemo();

        int scelta;

        do {
            System.out.println("Benvenuto nel Player Multimediale!");
            System.out.println("Vuoi guardare un'immagine o un video?");
            System.out.println("Oppure vuoi solo ascoltare qualcosa?");
            System.out.println("1 - Immagine");
            System.out.println("2 - Video");
            System.out.println("3 - Audio");
            System.out.println("0 - Chiudi demo.");

            scelta = scanner.nextInt();

            switch (scelta) {
                case 1 -> mostraImmagini(scanner, elementi);
                case 2 -> mostraVideo(scanner, elementi);
                case 3 -> mostraAudio(scanner, elementi);
                case 0 -> System.out.println("Chiusura demo.");
                default -> System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);
    }

    public static void mostraImmagini(Scanner scanner, ElementoMultimediale[] elementi) {

        int contatore = 1;

        for (ElementoMultimediale elemento : elementi) {
            if (elemento instanceof Immagine) {
                System.out.println(contatore + " - " + elemento.getTitolo());
                contatore++;
            }
        }

        System.out.println("Hai scelto Immagine!");
        System.out.println("Scegli un numero da 1 a 5 e ti mostrerò l'immagine corrispondente!");
        int sceltaImmagine = scanner.nextInt();

        Immagine immagineScelta = null;

        contatore = 1;

        for (ElementoMultimediale elemento : elementi) {
            if (elemento instanceof Immagine) {
                if (contatore == sceltaImmagine) {
                    immagineScelta = (Immagine) elemento;
                    break;
                }

                contatore++;
            }
        }
        if (immagineScelta != null) {

            immagineScelta.show();

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
                case 0 -> System.out.println("Nessuna modifica effettuata.");
                default -> System.out.println("Scelta non valida.");

            }

            System.out.println();
        } else {
            System.out.println("Scelta non valida.");
        }
    }

    public static void mostraVideo(Scanner scanner, ElementoMultimediale[] elementi) {

        int contatore = 1;

        for (ElementoMultimediale elemento : elementi) {
            if (elemento instanceof Video) {
                System.out.println(contatore + " - " + elemento.getTitolo());
                contatore++;
            }
        }

        System.out.println("Hai scelto Video!");
        System.out.println("Scegli un numero da 1 a 5 e ti mostrerò il video corrispondente!");
        int sceltaVideo = scanner.nextInt();

        Video videoScelto = null;

        contatore = 1;

        for (ElementoMultimediale elemento : elementi) {
            if (elemento instanceof Video) {
                if (contatore == sceltaVideo) {
                    videoScelto = (Video) elemento;
                    break;
                }

                contatore++;
            }
        }

        if (videoScelto != null) {

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
        } else {
            System.out.println("Scelta non valida.");
        }

    }

    public static void mostraAudio(Scanner scanner, ElementoMultimediale[] elementi) {

        int contatore = 1;

        for (ElementoMultimediale elemento : elementi) {
            if (elemento instanceof Audio) {
                System.out.println(contatore + " - " + elemento.getTitolo());
                contatore++;
            }
        }
        System.out.println("Hai scelto Audio!");
        System.out.println("Scegli un numero da 1 a 5 ed ascolterai l'audio corrispondente!");
        int sceltaAudio = scanner.nextInt();

        Audio audioScelto = null;

        contatore = 1;

        for (ElementoMultimediale elemento : elementi) {
            if (elemento instanceof Audio) {
                if (contatore == sceltaAudio) {
                    audioScelto = (Audio) elemento;
                    break;
                }
                contatore++;
            }
        }

        if (audioScelto != null) {

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
        } else {
            System.out.println("Scelta non valida.");
        }
    }
}


