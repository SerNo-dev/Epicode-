package es2;

public class Pagina implements Elemento{
    private String nome;

    public Pagina(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getPagine() {
        return 1;
    }

    @Override
    public void stampa() {
        System.out.println(nome);
    }
}
