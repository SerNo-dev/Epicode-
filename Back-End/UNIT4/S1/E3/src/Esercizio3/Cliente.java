package Esercizio3;

public class Cliente {
    private String codice;
    private String nome;
    private String cognome;
    private String email;
    private String DataIscrizione;


    public Cliente(String codice, String nome, String cognome, String email, String dataIscrizione) {
        this.codice = codice;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        DataIscrizione = dataIscrizione;
    }

    public String getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public String getDataIscrizione() {
        return DataIscrizione;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataIscrizione(String dataIscrizione) {
        DataIscrizione = dataIscrizione;
    }
}
