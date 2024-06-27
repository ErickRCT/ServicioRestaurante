package com.restaurante.ingrediente.service;

import com.restaurante.ingrediente.entity.Ingrediente;

import java.util.List;

public interface IngredienteService {

    List<Ingrediente> getIngredientes();

    void saveIngrediente(Ingrediente ingrediente);

    void deleteIngrediente(Long id);

    Ingrediente findIngredienteById(Long id);

    Ingrediente editIngrediente(Long id , Ingrediente ingrediente);

    List<Ingrediente> findIngredienteByNamePlato(String nombrePlato);
}
