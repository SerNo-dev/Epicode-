package it.esercizio4.E4.service;

import it.esercizio4.E4.bean.Ingrediente;
import it.esercizio4.E4.bean.Menu;
import it.esercizio4.E4.repository.IngredienteRepository;
import it.esercizio4.E4.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public void inserisciMenu(Menu menu) {
        menuRepository.save(menu);
    }
}
