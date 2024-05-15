package esercizio.E1;

import esercizio.E1.bean.Menu;
import esercizio.E1.bean.Ordine;
import esercizio.E1.bean.Pizza;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class E1ApplicationTests {


	public static ApplicationContext ctx;

	@BeforeAll
	public static void accediAlContesto() {
		ctx = new AnnotationConfigApplicationContext(E1Application.class);
		System.out.println("Accesso al contesto avvenuto");
	}



	@Test
	void verificaPizzaMargherita() {
		Pizza pizza = ctx.getBean("PizzaMargherita",Pizza.class);
		Assertions.assertEquals("Margherita",pizza.getNome());
	}

	@Test
	public void verificaOrdineNOTnull(){
		Ordine ordine = ctx.getBean(Ordine.class);
		Assertions.assertNotNull(ordine);
	}

	@Test void verificaPizzeNelMenu(){
    Menu menu = ctx.getBean(Menu.class);
	Assertions.assertEquals(3,menu.getPizze().size());
	}

	@ParameterizedTest
	@ValueSource(strings = {"M"})
   public void VerificaNumeroPizzeConNomeCheIniziaCon(String inizio){
		Menu menu = ctx.getBean(Menu.class);
		menu.getPizze().stream().filter(pizza -> pizza.getNome().startsWith(inizio)).forEach(System.out::println);
		long numero = menu.getPizze().stream().filter(pizza -> pizza.getNome().startsWith(inizio)).count();
		Assertions.assertEquals(2,numero);
	}

	@ParameterizedTest
	@CsvSource({"M,2","H,1"})
	public void verificaNumeroPizzeConNomeCheIniziaCon(String inizio,int conteggio){
		Menu menu = ctx.getBean(Menu.class);
        long numero = menu.getPizze().stream().filter(pizza -> pizza.getNome().startsWith(inizio)).count();
        Assertions.assertEquals(conteggio,numero);
	}

	@AfterAll
	public static void chiudiIlContesto() {
        ctx = null;
        System.out.println("Contesto chiuso");
    }
}
