package esercizio.E1;

import esercizio.E1.appConfig.AppConfig;
import esercizio.E1.bean.Bevanda;
import esercizio.E1.bean.Menu;
import esercizio.E1.bean.Pizza;
import esercizio.E1.bean.Topping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class E1Application {

	public static void main(String[] args) {
		SpringApplication.run(E1Application.class, args);


		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

       Menu menu = ctx.getBean( Menu.class);

		System.out.println("Menù:");
		System.out.println("Pizze:");
		for (Pizza pizza : menu.getPizze()) {
			System.out.println("- " + pizza.getNome() + " - €" + pizza.getPrezzo() + " -Calorie " + pizza.getCalorie());
			System.out.println("  Toppings:");
			for (Topping topping : pizza.getToppings()) {
				System.out.println("  * " + topping.getNome() + " - €" + topping.getPrezzo());
			}
		}
		System.out.println("Bevande:");
		for (Bevanda bevanda : menu.getBevande()) {
			System.out.println("- " + bevanda.getNome() + " - €" + bevanda.getPrezzo() + " -Calorie " + bevanda.getCalorie());
		}

	}


}
