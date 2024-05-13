package esercizio.E1.appConfig;

import esercizio.E1.bean.Bevanda;
import esercizio.E1.bean.Menu;
import esercizio.E1.bean.Pizza;

import esercizio.E1.bean.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;


@Configuration
public class AppConfig {

    @Bean
    public List<Topping> ingredientiBase() {
        return List.of(new Topping("Pomodoro", 0.5), new Topping("Mozzarella", 1.0));
    }

    @Bean
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



}
