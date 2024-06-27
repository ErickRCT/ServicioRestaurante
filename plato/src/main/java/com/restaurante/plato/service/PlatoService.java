package com.restaurante.plato.service;

import com.restaurante.plato.entity.Plato;

import java.util.List;

public interface PlatoService {

    List<Plato> getPlatos();

    void savePlato(Plato plato);

    void deletePlato(Long id);

    Plato getPlatoById(Long id);

    Plato editPlato(Long id ,Plato plato);
}
