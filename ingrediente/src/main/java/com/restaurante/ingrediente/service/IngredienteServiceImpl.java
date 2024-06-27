package com.restaurante.ingrediente.service;

import com.restaurante.ingrediente.entity.Ingrediente;
import com.restaurante.ingrediente.repository.IngredienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IngredienteServiceImpl implements IngredienteService {

    private IngredienteRepository ingredienteRepository;

    @Override
    public List<Ingrediente> getIngredientes() {
        return ingredienteRepository.findAll();
    }

    @Override
    public void saveIngrediente(Ingrediente ingrediente) {
        ingredienteRepository.save(ingrediente);
    }

    @Override
    public void deleteIngrediente(Long id) {
        ingredienteRepository.deleteById(id);
    }

    @Override
    public Ingrediente findIngredienteById(Long id) {
        return ingredienteRepository.findById(id).orElse(null);
    }

    @Override
    public Ingrediente editIngrediente(Long id, Ingrediente ingrediente) {
        Ingrediente ingredienteEditado = this.findIngredienteById(id);
        if (ingredienteEditado != null) {
            ingredienteEditado.setNombreIngrediente(ingrediente.getNombreIngrediente());
            ingredienteEditado.setPlatos(ingrediente.getPlatos());
            this.saveIngrediente(ingredienteEditado);
            return this.findIngredienteById(id);
        } else {
            return null;
        }
    }

    @Override
    public List<Ingrediente> findIngredienteByNamePlato(String nombrePlato) {
        return ingredienteRepository.findByNombre(nombrePlato);
    }
}
