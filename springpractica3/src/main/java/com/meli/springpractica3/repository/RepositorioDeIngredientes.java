package com.meli.springpractica3.repository;

import com.meli.springpractica3.dto.IngredienteDTO;

public interface RepositorioDeIngredientes {

    public int caloriasDeIngrediente(IngredienteDTO ingrediente);
}
