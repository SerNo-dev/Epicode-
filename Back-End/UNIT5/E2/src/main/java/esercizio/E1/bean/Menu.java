package esercizio.E1.bean;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private List<Pizza> pizze;
    private List<Bevanda> bevande;


}
