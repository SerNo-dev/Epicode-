public class DipendentePartTime extends Dipendente {
   int ore;
    public DipendentePartTime(int matricola,double stipendio, String[] dipartimento,int ore){
        super(matricola, stipendio, dipartimento);
        this.ore = ore;
    }

    @Override
    public double getStipendio() {
        return super.getStipendio();
    }

    @Override
    public void setStipendio(double stipendio) {
        super.setStipendio(stipendio);
    }

    @Override
    public double calculateSalary() {

        double salarioOrario = 20.0;
       double  stipendio = salarioOrario * ore;

       setStipendio(stipendio);
         return stipendio;
    }
}
