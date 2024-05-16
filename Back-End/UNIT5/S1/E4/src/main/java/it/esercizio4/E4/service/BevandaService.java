package it.esercizio4.E4.service;

import it.esercizio4.E4.bean.Bevanda;
import it.esercizio4.E4.repository.BevandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BevandaService {

    @Autowired
    private BevandaRepository bevandaRepository;

    public void inserisciBevanda(Bevanda bevanda){
        bevandaRepository.save(bevanda);
    }

    public Bevanda  getBevanda(int id){
      return  bevandaRepository.findById(id).get();
    }

    public List<Bevanda> getBevande(){
        return bevandaRepository.findAll();
    }

    public void eliminaBevanda(int id){
        bevandaRepository.deleteById(id);
    }

    public List<Bevanda> getBevandeByName(String nome){
        return bevandaRepository.findByNome(nome);
    }
}
