package entities;

public class Immagine extends ElementoMultimediale {

    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita=luminosita;
    }


    public void show(){
        String asterischi = "";
        for(int i=0; i<luminosita; i++){
            asterischi += "*";
        }
        System.out.println(titolo+ " " + asterischi);
    }

    public int getLuminosita(){
        return luminosita;
    }

    public void alzaLuminosita(){
        luminosita++;
    }

    public void abbassaLuminosita(){
        if(luminosita > 0){
            luminosita--;
        }
    }
}
