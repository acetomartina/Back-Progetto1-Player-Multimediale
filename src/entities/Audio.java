package entities;
import interfaces.RegolaVolume;
import interfaces.Riproducibile;

public class Audio extends ElementoMultimediale implements Riproducibile, RegolaVolume {

    private int durata;
    private int volume;

    public Audio(String titolo, int durata,int volume) {
        super(titolo);
        this.durata=durata;
        this.volume=volume;
    }

    public int getDurata(){
        return durata;
    }

    public int getVolume(){
        return volume;
    }


    @Override
    public void play(){
        String puntiEsclamativi="";

        for (int i=0; i<volume ; i++){
            puntiEsclamativi += "!";
        }

        for (int i=0; i<durata; i++){
            System.out.println(titolo + puntiEsclamativi);
        }
    }

    @Override
    public void alzaVolume() {
        volume++;
    }

    @Override
    public void abbassaVolume(){
        if( volume > 0 ){
            volume--;
        }
    }





}
