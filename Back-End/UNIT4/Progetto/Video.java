public class Video extends Riproduzione {
  int volume;
  int luminosita;

    public Video(ElementoMultimediale elementiMultimediali,String titolo, int durata,int volume,int luminosita) {
        super(elementiMultimediali, durata);
        this.volume = volume;
        this.luminosita = luminosita;
        this.getElementiMultimediali().titolo = titolo;
    }

    public int getVolume() {
        return volume;
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

    @Override
    public void play() {
        ElementoMultimediale elemento = getElementiMultimediali();
        for (int i = 0; i < getDurata(); i++) {
            String esclamativi = "!".repeat(getVolume());
            String asterischi = "*".repeat(getLuminosita());
            System.out.println(elemento.getTitolo() + esclamativi + asterischi);
        }
    }
}
