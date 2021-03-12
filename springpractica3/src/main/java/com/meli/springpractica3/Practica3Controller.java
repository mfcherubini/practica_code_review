package com.meli.springpractica3;

import com.meli.springpractica3.dto.CalculoCaloricoDTO;
import com.meli.springpractica3.dto.PlatoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.meli.springpractica3.repository.RepositorioDeIngredientesImpl;
import com.meli.springpractica3.service.CalculadorCalorico;
import com.meli.springpractica3.service.CalculadorCaloricoImpl;


@RestController
public class Practica3Controller {

    @Autowired
    private CalculadorCalorico calculador;

    public Practica3Controller() {
        RepositorioDeIngredientesImpl repo = new RepositorioDeIngredientesImpl();
        this.calculador = new CalculadorCaloricoImpl(repo);
    }

    public Practica3Controller(CalculadorCalorico calculador) {this.calculador = calculador;}

    @PostMapping(path="/calorias/")
    public CalculoCaloricoDTO getCalorias(@RequestBody PlatoDTO plato) {
        return calculador.calcular(plato);
    }
}
