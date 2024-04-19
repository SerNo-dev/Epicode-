public class RegistrazioneAudio extends Riproduzione {
    private int volume;

    public RegistrazioneAudio(ElementoMultimediale elementiMultimediali,String titolo, int durata, int volume) {
        super(elementiMultimediali, durata);
        this.volume = volume;
        this.getElementiMultimediali().titolo = titolo;
    }

    public int getVolume() {
        return volume;
    }

    public void abbassaVolume() {
        if (volume > 0) {
            System.out.println("Abbassamento del volume da " + volume + " a " + (volume - 1));
            volume--;
        }
    }

    public void alzaVolume() {
        if (volume < 100) {
            System.out.println("Alzamento volume da " + volume + " a " + (volume + 1));
            volume++;
        }
    }


    @Override
    public void play() {
        ElementoMultimediale elemento = getElementiMultimediali();
        for (int i = 0; i < getDurata(); i++) {
            String esclamativi = "!".repeat(getVolume());
            System.out.println(elemento.getTitolo() + esclamativi);
        }
    }


}
