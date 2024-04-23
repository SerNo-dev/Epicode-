package Esercizio2;

import java.util.*;

public class esercizio2 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Quanti numeri vuoi Casuali?");
       int n = scanner.nextInt();

      List<Integer> lista = listaRandomOrdinata(n);
        System.out.println(lista);

        List<Integer> listaModificata = NuovaLISTA(lista);
        System.out.println(listaModificata);

        stampa(lista,false);
    }


    public static List<Integer> listaRandomOrdinata(int dimensione) {

        List<Integer> listaRandom = new ArrayList<>();
        for (int i = 0; i < dimensione; i++) {
            int numeroRandom = new Random().nextInt(0, 101);
            listaRandom.add(numeroRandom);
        }
         Collections.sort(listaRandom);
        return listaRandom;

    }

    public static List<Integer> NuovaLISTA(List<Integer> lista){
        List<Integer> listaCompleta = new ArrayList<>(lista);
         Collections.reverse(listaCompleta);
         lista.addAll(listaCompleta);
         return lista;
    }

    public static void stampa(List<Integer> lista, boolean pari){
      for(int i =0; i< lista.size(); i++){
          if(pari && i % 2 == 0){
              System.out.println(lista.get(i));
          } else if(i %2 != 0) {
              System.out.println(lista.get(i));
          }
      }
    }
}
