import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        List<Product> Prodotti = new ArrayList<>();

        Prodotti.add(new Product(1,"Signore Degli Anelli","Books",40));
        Prodotti.add(new Product(4,"Signore ","Books",220));
        Prodotti.add(new Product(5,"Harry Potter","Books",240));
        Prodotti.add(new Product(33,"ComputerScience","Books",40));

        Prodotti.add(new Product(3,"Mutande","Baby",40));
        Prodotti.add(new Product(20,"calzini","Baby",220));
        Prodotti.add(new Product(30,"Giocattoli","Baby",240));
        Prodotti.add(new Product(40,"Cellulari","Baby",40));


        Prodotti.add(new Product(40,"Moto","Boys",40));
        Prodotti.add(new Product(23,"Playstation","Boys",220));
        Prodotti.add(new Product(123,"Sigarette","Boys",240));
        Prodotti.add(new Product(11,"Macchina","Boys",40));



        Prodotti.stream()
                .filter(book -> "Books".equals(book.getCategory()) && book.getPrice() > 100)
                .forEach(System.out::println);



        List<Product> baby = Prodotti.stream()
                .filter(prodotto -> "Baby".equals(prodotto.getCategory()))
                .collect(Collectors.toList());


        Customer cliente = new Customer(233, "Pippo", 2);
        Customer cliente1 = new Customer(2, "Marco", 2);
        Customer cliente2 = new Customer(43, "Carlo", 2);


        List<Order> Ordini = new ArrayList<>();

        List<Product> boys = Prodotti.stream()
                .filter(prodotto -> "Boys".equals(prodotto.getCategory()))
                .map(boy -> {
                    boy.setPrice(boy.getPrice() * 0.90);
                    return boy;
                })
                .collect(Collectors.toList());

        System.out.println(boys);

        Order order1 = new Order(20, "avaiable", LocalDate.of(2022, 10, 5), LocalDate.of(2023, 10, 10), baby, cliente);
        Order order2 = new Order(20, "avaiable", LocalDate.of(2022, 10, 5), LocalDate.of(2023, 10, 10), boys, cliente1);
        Order order3 = new Order(20, "avaiable", LocalDate.of(2022, 10, 5), LocalDate.of(2023, 10, 10), baby, cliente);
        Ordini.add(order1);
        Ordini.add(order2);
        Ordini.add(order3);


        Ordini.forEach(order -> {
            System.out.println("Order ID: " + order.getId());
            System.out.println("Status: " + order.getStatus());
            System.out.println("Order Date: " + order.getOrderDate());
            System.out.println("Delivery Date: " + order.getDeliveryDate());
            System.out.println("Products:");
            order.getProducts().forEach(product -> {
                System.out.println("\t" + product.getName() + " - " + product.getCategory() + " - " + product.getPrice());
            });
            System.out.println("Customer: " + order.getCustomer());
            System.out.println();
        });




    }
}