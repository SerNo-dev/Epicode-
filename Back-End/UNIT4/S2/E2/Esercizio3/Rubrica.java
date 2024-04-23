package Esercizio3;

import java.util.HashMap;
import java.util.Set;

public class Rubrica {

    private HashMap<String,String> rubrica;

    public Rubrica(){
        rubrica = new HashMap<>();
    }

    public void inserisciContatto(String nome,String numero){
        rubrica.put(nome,numero);
    }

    public void rimuoviContatto(String nome){
        rubrica.remove(nome);
    }
    public String cercaPerNome(String nome){
       return rubrica.get(nome); // gli passiamo il nome e restituisce il numero
    }

    public String cercaPerTelefono(String numero){
       Set<String> nomi = rubrica.keySet(); //estraiamo tutti i nomi della rubrica e li mettiamo in un set di nomi(stringhe)

        for(String nome: nomi){
            String numeroTelefono = rubrica.get(nome); // prendiamo il numero di telefono associato ad uno dei nomi associati nel ciclo
            if(numeroTelefono.equals(numero)){  // cosi trovo il nome,se il numero di telefono é uguale al numero
                return nome;
            }
        }
        return null;// non ho trovato il nome associato qui
    }

    public  void stampaRubrica(){
        System.out.println(rubrica);
    }

    @Override
    public String toString() {
        return "Rubrica{" +
                "rubrica=" + rubrica +
                '}';
    }
}
