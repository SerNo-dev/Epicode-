package esercizio.E1;


import esercizio.E1.appConfig.AppConfig;
import esercizio.E1.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class MyCommandLineRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(MyCommandLineRunner.class);
    @Override
    public void run(String... args) throws Exception {
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
        Ordine ordine = ctx.getBean(Ordine.class);
        logger.info("Dettagli dell'ordine:");
        logger.info("Numero ordine: {}", ordine.getNumeroOrdine());
        logger.info("Stato: {}", ordine.getStato());
        logger.info("Numero coperti: {}", ordine.getNumeroCoperti());
        logger.info("Ora acquisizione: {}", ordine.getOraAcquisizione());
        logger.info("Prezzo totale: {}", ordine.getPrezzoTotale());

    }
}
