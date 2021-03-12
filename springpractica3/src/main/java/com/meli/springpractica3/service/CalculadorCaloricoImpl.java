package com.meli.springpractica3.service;

import com.meli.springpractica3.dto.CalculoCaloricoDTO;
import com.meli.springpractica3.dto.IngredienteDTO;
import com.meli.springpractica3.dto.PlatoDTO;
import org.springframework.stereotype.Service;
import com.meli.springpractica3.repository.RepositorioDeIngredientes;

import java.util.HashMap;

@Service
public class CalculadorCaloricoImpl implements CalculadorCalorico {

    private RepositorioDeIngredientes repositorioDeIngredientes;

    public CalculadorCaloricoImpl(RepositorioDeIngredientes unRepositorio){
        this.repositorioDeIngredientes = unRepositorio;
    }

    @Override
    public CalculoCaloricoDTO calcular(PlatoDTO plato) {

        CalculoCaloricoDTO calculo = new CalculoCaloricoDTO();

        double caloriasTotales= 0;
        double calorias = 0;
        double maxCalorias = 0;
        double pesoDelIngrediente = 0;
        IngredienteDTO ingredienteConMasCalorias = null;
        HashMap<String,Double> caloriasDeCadaIngrediente = new HashMap<String,Double>();

        for(IngredienteDTO ing : plato.getIngridients()) {

            calorias = repositorioDeIngredientes.caloriasDeIngrediente(ing);
            caloriasDeCadaIngrediente.put(ing.getName(), calorias);
            pesoDelIngrediente = ing.getWeight()/100;
            caloriasTotales += pesoDelIngrediente*calorias;

            if (calorias > maxCalorias) {
                maxCalorias = calorias;
                ingredienteConMasCalorias = ing;
            }
        }

        calculo.setTotalCalories(caloriasTotales);
        calculo.setCaloriesPerIngridient(caloriasDeCadaIngrediente);
        calculo.setMostCaloricIngridient(ingredienteConMasCalorias);

        return calculo;
    }
}
