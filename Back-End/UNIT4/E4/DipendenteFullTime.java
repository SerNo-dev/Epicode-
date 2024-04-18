public class DipendenteFullTime extends Dipendente {

    public DipendenteFullTime(int matricola,double stipendio, String[] dipartimento){
        super(matricola, stipendio, dipartimento);

    }


    @Override
    public double getStipendio() {
        return super.getStipendio();
    }




    @Override
    public double calculateSalary() {
        return 1200;
    }
}
