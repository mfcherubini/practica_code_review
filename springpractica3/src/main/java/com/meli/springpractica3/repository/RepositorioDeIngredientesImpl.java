package com.meli.springpractica3.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.springpractica3.dto.CaloriasDTO;
import com.meli.springpractica3.dto.IngredienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.util.List;

@Repository
public class RepositorioDeIngredientesImpl implements RepositorioDeIngredientes {

    private List<CaloriasDTO> caloriasDTOS;

    public RepositorioDeIngredientesImpl() {caloriasDTOS = loadDataBase();}

    @Override
    public int caloriasDeIngrediente(IngredienteDTO ingrediente){

        int caloriasDelIngrediente = 0;
        String aux1;
        String aux2;

        if (caloriasDTOS != null) {
            for (CaloriasDTO cal : caloriasDTOS) {
                aux1 = cal.getName();
                aux2 = ingrediente.getName();
                if (aux1.compareTo(aux2) == 0) {
                    caloriasDelIngrediente = cal.getCalories();
                    break;
                }
            }
        } else {
            throw new RuntimeException("Falta cargar una base de datos de ingredientes.");
        }

        return caloriasDelIngrediente;
    }


    private List<CaloriasDTO> loadDataBase() {
        List<CaloriasDTO> caloriasDTOS = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            caloriasDTOS = mapper.readValue(ResourceUtils.getFile("food.json"), mapper.getTypeFactory().constructCollectionType(List.class, CaloriasDTO.class));

        } catch (IOException e) {

            e.printStackTrace();
            throw new RuntimeException("No se pudo cargar el archivo.");
        }

        return caloriasDTOS;
    }
}
