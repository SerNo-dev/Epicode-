package esercizio.E1.appConfig;

import esercizio.E1.bean.*;

import esercizio.E1.enums.StatoOrdine;
import esercizio.E1.enums.StatoTavolo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import java.time.LocalDateTime;
import java.util.List;



@Configuration
public class AppConfig {

    @Bean
    public List<Topping> ingredientiBase() {
        return List.of(new Topping("Pomodoro", 0.5), new Topping("Mozzarella", 1.0));
    }


    @Bean("PizzaMargherita")
    public Pizza margherita() {
        return new Pizza("Margherita", 4.0, ingredientiBase(),900);
    }

    @Bean
    public Pizza margheritaConProsciutto() {
        Pizza pizza = new Pizza("Margherita con Prosciutto", 5.0, ingredientiBase(),1104);
        pizza.setToppings(List.of(new Topping("Prosciutto", 1.5)));
        return pizza;
    }


    @Bean
    public Bevanda lemonade(){
         Bevanda bevanda = new Bevanda();
         bevanda.setNome("Lemonade");
         bevanda.setPrezzo(2.0);
         bevanda.setCalorie(128);
         return bevanda;
    }

    @Bean
   public Menu menu(){
         Menu menu = new Menu();
         menu.setPizze(List.of(margherita(),hawaiian(),margheritaConProsciutto()));
         menu.setBevande(List.of(lemonade()));
         return menu;
    }

    public Pizza hawaiian() {
        Pizza pizza = new Pizza("Hawaiian", 6.0, ingredientiBase(), 1200);
        pizza.setToppings(List.of(new Topping("Prosciutto", 1.5), new Topping("Ananas", 1.0)));
        return pizza;
    }




    @Bean
    public Tavolo tavolo() {
        Tavolo tavolo = new Tavolo();
        tavolo.setStato(StatoTavolo.LIBERO);
        tavolo.setNumero(5);
        tavolo.setCopertiMassimi(5);
        return tavolo;
    }

    @Bean
    public Ordine ordine(List<Menu> menu) {
        Ordine ordine = new Ordine();
        ordine.setNumeroOrdine(1);
        ordine.setStato(StatoOrdine.SERVITO);
        ordine.setNumeroCoperti(4);
        ordine.setOraAcquisizione(LocalDateTime.now());
        ordine.setMenu(menu);
        return ordine;
    }

}
