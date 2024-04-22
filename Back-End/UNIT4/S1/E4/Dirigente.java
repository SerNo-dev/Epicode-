public class Dirigente extends Dipendente {

    public Dirigente(int matricola,double stipendio, String[] dipartimento){
        super(matricola, stipendio, dipartimento);

    }

    @Override
    public double getStipendio() {
        return super.getStipendio();
    }

    @Override
    public double calculateSalary() {
        return 2500;
    }
}
