package entities;
import interfaces.Riproducibile;

public class Audio extends ElementoMultimediale implements Riproducibile{

    private double durata;
    private int volume;

    public Audio(String titolo, int durata,int volume) {
        super(titolo);
        this.durata=durata;
        this.volume=volume;
    }


    @Override
    public void play(){
    }


    }

}
