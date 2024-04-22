public class Immagine extends Riproduzione{
 private int luminosita;
    public Immagine(ElementoMultimediale elementiMultimediali,String titolo, int durata,int luminosita) {
        super(elementiMultimediali, durata);
        this.luminosita = luminosita;
        this.getElementiMultimediali().titolo = titolo;
    }

    public int getLuminosita() {
        return luminosita;
    }

    public void aumentaLuminosita(){
        if(luminosita > 0){
            System.out.println("Abbassamento della luminosita" + luminosita + " a " + (luminosita - 1));
            luminosita--;
        }
    }

    public void diminuisciLuminosita(){
        if(luminosita < 100){
            System.out.println("Abbassamento della luminosita" + luminosita + " a " + (luminosita - 1));
            luminosita++;
        }
    }

    public void show(){

             String asterischi = "*".repeat(getLuminosita());
             System.out.println(ElementoMultimediale.Immagine + asterischi);

    }

    @Override
    public void play() {
        String asterischi = "*".repeat(getLuminosita());
        System.out.println(ElementoMultimediale.Immagine + asterischi);
    }
}
