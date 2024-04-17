public class StampaRettangoli {

    public static void main(String[] args) {

        stampaRettangolo();


        Rettangolo rettangolo1 = new Rettangolo(10,20);

        Rettangolo rettangolo2 = new Rettangolo(40,50);

        stampaDueRettangoli(rettangolo1,rettangolo2);
        
    }

    public static void stampaRettangolo(){
        Rettangolo rettangolo1 = new Rettangolo(20,30);
        System.out.println("Perimetro del rettangolo = "+rettangolo1.Perimetro(rettangolo1.getAltezza(),rettangolo1.getLarghezza()));
        System.out.println("Area del rettangolo= "+ rettangolo1.Area(rettangolo1.getAltezza(),rettangolo1.getLarghezza()));
    }

    public static void stampaDueRettangoli(Rettangolo rettangolo1,Rettangolo rettangolo2){
        int areaRettangolo1 = rettangolo1.Area(rettangolo1.getAltezza(), rettangolo1.getLarghezza());
        int perimetroRettangolo1 = rettangolo1.Perimetro(rettangolo1.getAltezza(),rettangolo1.getLarghezza());
        int areaRettangolo2 = rettangolo2.Area(rettangolo2.getAltezza(), rettangolo2.getLarghezza());
        int perimetroRettangolo2 = rettangolo1.Perimetro(rettangolo1.getAltezza(),rettangolo1.getLarghezza());
        System.out.println("Area del rettangolo 1: " + areaRettangolo1);
        System.out.println("Perimetro del rettangolo 1: " + perimetroRettangolo1);
        System.out.println("Area del rettangolo 2: " + areaRettangolo2);
        System.out.println("Perimetro del rettangolo 2: " + perimetroRettangolo2);

        int sommaPerimetri = perimetroRettangolo1 + perimetroRettangolo2;
        int sommaArea = areaRettangolo1 + areaRettangolo2;
        System.out.println("Somma delle aree " + sommaArea);
        System.out.println("Somma dei perimetri " + sommaPerimetri);
    }

}
