public abstract   class Riproduzione {

    private ElementoMultimediale elementiMultimediali;
    private int durata;

    public Riproduzione(ElementoMultimediale elementiMultimediali, int durata) {
        this.elementiMultimediali = elementiMultimediali;
        this.durata = durata;
    }

    public ElementoMultimediale getElementiMultimediali() {
        return elementiMultimediali;
    }

    public int getDurata() {
        return durata;
    }

    public void setElementiMultimediali(ElementoMultimediale elementiMultimediali) {
        this.elementiMultimediali = elementiMultimediali;
    }

    public void setDurara(int durara) {
        this.durata = durara;
    }

    public abstract void play();

    public void show(){

    }
}
