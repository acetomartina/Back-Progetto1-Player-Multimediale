package entities;

import interfaces.RegolaLuminosita;

public class Immagine extends ElementoMultimediale implements RegolaLuminosita {

    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita=luminosita;
    }

    public int getLuminosita(){
        return luminosita;
    }


    public void show(){
        String asterischi = "";
        for(int i=0; i<luminosita; i++){
            asterischi += "*";
        }
        System.out.println(titolo+ " " + asterischi);
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
