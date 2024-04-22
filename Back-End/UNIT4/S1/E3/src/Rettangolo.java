public class Rettangolo {
    private int altezza;
    private int larghezza;

    public Rettangolo(int _altezza,int _larghezza){
        this.altezza = _altezza;
        this.larghezza = _larghezza;
    }

   public int Perimetro(int altezza,int larghezza){
        int perimetro = (altezza + larghezza)*2;
        return perimetro;
   }

   public int Area (int altezza,int larghezza){
        int area = altezza*larghezza;
        return area;
   }

    public int getAltezza() {
        return altezza;
    }

    public int getLarghezza() {
        return larghezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    public void setLarghezza(int larghezza) {
        this.larghezza = larghezza;
    }
}
