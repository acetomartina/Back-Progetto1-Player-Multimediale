package entities;

import interfaces.RegolaLuminosita;
import interfaces.RegolaVolume;
import interfaces.Riproducibile;

public class Video extends ElementoMultimediale implements Riproducibile, RegolaVolume, RegolaLuminosita {

    private int volume;
    private int durata;
    private int luminosita;

    public Video(String titolo, int volume, int durata, int luminosita) {
        super(titolo);
        this.volume=volume;
        this.durata=durata;
        this.luminosita=luminosita;
    }

    public int getLuminosita(){
        return luminosita;
    }

    public int getVolume(){
        return volume;
    }

    public int getDurata(){
        return durata;
    }

    @Override
    public void play() {
        String puntiEsclamativi = "";
        String asterischi = "";

        for (int i = 0; i < volume; i++) {
            puntiEsclamativi += "!";
        }

        for (int i = 0; i < luminosita; i++) {
            asterischi += "*";
        }

        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + " " + puntiEsclamativi + " " + asterischi);
        }
    }

    @Override
    public void alzaVolume(){
        volume++;
    }

    @Override
    public void abbassaVolume(){
        if(volume > 0){
            volume--;
        }
    }

    @Override
    public void alzaLuminosita(){
        luminosita++;
    }

    @Override
    public void abbassaLuminosita(){
        if(luminosita > 0){
            luminosita--;
        }
    }






}
