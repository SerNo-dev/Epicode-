package it.esercizio4.E4.service;

import it.esercizio4.E4.bean.Bevanda;
import it.esercizio4.E4.bean.Ingrediente;
import it.esercizio4.E4.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IngredienteService {

    @Autowired
   private IngredienteRepository ingredienteRepository;

    public void inserisciIngrediente(Ingrediente ingrediente) {
        ingredienteRepository.save(ingrediente);
    }

    public Ingrediente  getIngrediente(int id){
        return  ingredienteRepository.findById(id).get();
    }

    public List<Ingrediente> getIngredienti(){
        return ingredienteRepository.findAll();
    }

    public void eliminaIngrediente(int id){
        ingredienteRepository.deleteById(id);
    }
}
