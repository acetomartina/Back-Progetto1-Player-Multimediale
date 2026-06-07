package services;

import entities.Audio;
import entities.ElementoMultimediale;
import entities.Immagine;
import entities.Video;

import java.util.Scanner;

public class UserPlayer {
    public static ElementoMultimediale[] creaLibreriaPersonalizzata(Scanner scanner){

        System.out.println("Quanti elementi vuoi creare?");
        int numeroElementi = scanner.nextInt();

        ElementoMultimediale[] elementi = new ElementoMultimediale[numeroElementi];

        for (int i = 0; i < numeroElementi; i++) {

            System.out.println();
            System.out.println("Creazione elemento " + (i+1));;

            System.out.println("Che tipo di elemento vuoi creare?");
            System.out.println("1 - Immagine");
            System.out.println("2 - Audio");
            System.out.println("3 - Video");

            int tipo = scanner.nextInt();

            switch (tipo) {
                case 1 -> {
                    System.out.println("Titolo immagine: ");
                    scanner.nextLine();
                    String titolo = scanner.nextLine();

                    System.out.println("Luminosità:");
                    int luminosita = scanner.nextInt();

                    elementi[i] = new Immagine(titolo,luminosita);
                }
                case 2 -> {
                    System.out.println("Titolo audio: ");
                    scanner.nextLine();
                    String titolo = scanner.nextLine();

                    System.out.println("Durata dell'audio: ");
                    int durata = scanner.nextInt();

                    System.out.println("Volume dell'audio: ");
                    int volume = scanner.nextInt();

                    elementi[i] = new Audio(titolo,durata,volume);
                }
                case 3 -> {
                    System.out.println("Titolo video: ");
                    scanner.nextLine();
                    String titolo = scanner.nextLine();

                    System.out.println("Durata del video: ");
                    int durata = scanner.nextInt();

                    System.out.println("Volume del video: ");
                    int volume = scanner.nextInt();

                    System.out.println("Luminosità del video: ");
                    int luminosita = scanner.nextInt();

                    elementi[i] = new Video(titolo,volume,durata,luminosita);
                }
                default -> {
                    System.out.println("Scelta non valida.");
                    i--;
                }

            }
        }

        return elementi;
    }

    public static void  avviaPlayer(Scanner scanner, ElementoMultimediale[] elementi) {

        int scelta;
        do {
            System.out.println("Scegli un elemento da visualizzare o da riprodurre.");

            for (int i = 0; i < elementi.length; i++) {
                System.out.println((i + 1) + " - " + elementi[i].getTitolo());
            }

            System.out.println("0 - Esci");

            scelta = scanner.nextInt();

            if (scelta >= 1 && scelta <= elementi.length) {

                ElementoMultimediale elementoScelto = elementi[scelta - 1];

                if (elementoScelto instanceof Immagine) {
                    Immagine immagine = (Immagine) elementoScelto;
                    System.out.println();
                    System.out.println("Luminosità attuale: " + immagine.getLuminosita());
                    System.out.println();
                    System.out.println("Vuoi modificare la luminosità?");
                    System.out.println("1 - Aumenta la luminosità");
                    System.out.println("2 - Diminuisci la luminosità");
                    System.out.println("0 - No");

                    int sceltaLuminosita = scanner.nextInt();

                    switch (sceltaLuminosita) {
                        case 1 -> {
                            immagine.alzaLuminosita();
                            System.out.println("Luminosità aumentata: " + immagine.getLuminosita());
                            immagine.show();
                        }
                        case 2 -> {
                            immagine.abbassaLuminosita();
                            System.out.println("Luminosità diminuita: " + immagine.getLuminosita());
                            immagine.show();
                        }
                        case 0 -> System.out.println("Nessuna modifica effettuata.");
                        default -> System.out.println("Scelta non valida.");
                    }

                } else if (elementoScelto instanceof Audio) {
                    Audio audio = (Audio) elementoScelto;
                        audio.play();

                        System.out.println();
                        System.out.println("Durata: " + audio.getDurata());
                        System.out.println("Volume attuale: " + audio.getVolume());
                        System.out.println();

                        System.out.println("Vuoi modificare qualcosa?");
                        System.out.println("1 - Aumenta volume");
                        System.out.println("2 - Diminuisci volume");
                        System.out.println("0 - No");

                        int sceltaAudio = scanner.nextInt();

                        switch (sceltaAudio) {
                            case 1 -> {
                                audio.alzaVolume();
                                System.out.println("Volume aumentato: " + audio.getVolume());
                                audio.play();
                            }

                            case 2 -> {
                                audio.abbassaVolume();
                                System.out.println("Volume diminuito: " + audio.getVolume());
                                audio.play();
                            }

                            case 0 -> System.out.println("Nessuna modifica effettuata.");

                            default -> System.out.println("Scelta non valida.");
                        }

                } else if (elementoScelto instanceof Video) {
                    Video video = (Video) elementoScelto;
                        video.play();

                        System.out.println();
                        System.out.println("Durata: " + video.getDurata());
                        System.out.println("Volume attuale: " + video.getVolume());
                        System.out.println("Luminosità attuale: " + video.getLuminosita());
                        System.out.println();

                        System.out.println("Vuoi modificare qualcosa?");
                        System.out.println("1 - Aumenta volume");
                        System.out.println("2 - Diminuisci volume");
                        System.out.println("3 - Aumenta luminosità");
                        System.out.println("4 - Diminuisci luminosità");
                        System.out.println("0 - No");

                        int sceltaVideo = scanner.nextInt();

                        switch (sceltaVideo) {

                            case 1 -> {
                                video.alzaVolume();
                                System.out.println("Volume aumentato: " + video.getVolume());
                                video.play();
                            }

                            case 2 -> {
                                video.abbassaVolume();
                                System.out.println("Volume diminuito: " + video.getVolume());
                                video.play();
                            }

                            case 3 -> {
                                video.alzaLuminosita();
                                System.out.println("Luminosità aumentata: " + video.getLuminosita());
                                video.play();
                            }

                            case 4 -> {
                                video.abbassaLuminosita();
                                System.out.println("Luminosità diminuita: " + video.getLuminosita());
                                video.play();
                            }

                            case 0 -> System.out.println("Nessuna modifica effettuata.");

                            default -> System.out.println("Scelta non valida.");
                        }
                }

            } else if (scelta == 0) {
                    System.out.println("Chiusura visualizzazione.");

                } else {
                    System.out.println("Scelta non valida.");
                }
        } while (scelta != 0);
    }
}
