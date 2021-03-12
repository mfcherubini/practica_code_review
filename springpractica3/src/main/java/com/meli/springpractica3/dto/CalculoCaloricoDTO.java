package com.meli.springpractica3.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class CalculoCaloricoDTO {
    double totalCalories;
    HashMap<String,Double> caloriesPerIngridient;
    IngredienteDTO mostCaloricIngridient;
}
