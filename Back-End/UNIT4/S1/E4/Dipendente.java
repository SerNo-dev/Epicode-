public abstract class Dipendente implements Turno{

    private int matricola;
    private double stipendio;
    private String[] dipartimento;

    public Dipendente(int matricola,double stipendio,String[] dipartimento ){
        this.matricola = matricola;
        this.stipendio = stipendio;
        this.dipartimento = dipartimento;
    }

    public int getMatricola() {
        return matricola;
    }

    public double getStipendio() {
        return stipendio;
    }

    public String[] getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(String[] dipartimento) {
        this.dipartimento = dipartimento;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public abstract double calculateSalary();


    @Override
    public void checkIn() {
        System.out.println("Il dipendente "+ matricola + " ha iniziato il suo turno");
    }
}
