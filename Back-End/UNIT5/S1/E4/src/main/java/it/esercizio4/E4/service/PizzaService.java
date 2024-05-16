package it.esercizio4.E4.service;

import it.esercizio4.E4.bean.Ingrediente;
import it.esercizio4.E4.bean.Pizza;
import it.esercizio4.E4.repository.IngredienteRepository;
import it.esercizio4.E4.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public void inserisciPizza(Pizza pizza) {
       pizzaRepository.save(pizza);
    }

    public Pizza  getPizza(int id){
        return  pizzaRepository.findById(id).get();
    }

    public List<Pizza> getPizze(){
        return pizzaRepository.findAll();
    }

    public void eliminaPizza(int id){
        pizzaRepository.deleteById(id);
    }

    public Integer contaPizze(){
        return pizzaRepository.findCountofPizze();
    }
}
