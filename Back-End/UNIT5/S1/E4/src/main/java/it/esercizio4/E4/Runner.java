package it.esercizio4.E4;

import it.esercizio4.E4.bean.Bevanda;
import it.esercizio4.E4.bean.Ingrediente;
import it.esercizio4.E4.bean.Menu;
import it.esercizio4.E4.bean.Pizza;
import it.esercizio4.E4.service.BevandaService;
import it.esercizio4.E4.service.IngredienteService;
import it.esercizio4.E4.service.MenuService;
import it.esercizio4.E4.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private BevandaService bevandaService;
    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private IngredienteService ingredienteService;


    @Autowired
    private MenuService menuService;



    @Override
    public void run(String... args) throws Exception {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(E4Application.class);

        Bevanda bevanda1 = ctx.getBean("birra",Bevanda.class);
        bevandaService.inserisciBevanda(bevanda1);

        Ingrediente ingrediente1 = ctx.getBean("mozzarella",Ingrediente.class);
        ingredienteService.inserisciIngrediente(ingrediente1);

        Pizza pizza1 = ctx.getBean("diavola",Pizza.class);
        pizzaService.inserisciPizza(pizza1);


        System.out.println(bevandaService.getBevandeByName("birra"));

        System.out.println(pizzaService.contaPizze());
    }
}
