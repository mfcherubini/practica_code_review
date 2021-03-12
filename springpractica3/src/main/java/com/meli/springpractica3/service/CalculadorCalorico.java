package com.meli.springpractica3.service;

import com.meli.springpractica3.dto.CalculoCaloricoDTO;
import com.meli.springpractica3.dto.PlatoDTO;

public interface CalculadorCalorico {

    public CalculoCaloricoDTO calcular(PlatoDTO plato);
}
