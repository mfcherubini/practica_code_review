package com.meli.springpractica3.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlatoDTO {
    String name;
    List<IngredienteDTO> ingridients;

}
