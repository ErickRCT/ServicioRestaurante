package com.restaurante.plato.service;

import com.restaurante.plato.dto.IngredienteDto;
import com.restaurante.plato.entity.Plato;
import com.restaurante.plato.repository.PlatoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class PlatoServiceImpl implements PlatoService {

    private PlatoRepository platoRepository;

    private RestTemplate consumirApiIngrediente;


    @Override
    public List<Plato> getPlatos() {
        return platoRepository.findAll();
    }

    @Override
    public void savePlato(Plato plato) {
        List<String> ingredientes;
        ingredientes = new ArrayList<String>();
        List<IngredienteDto> listaIngredientes = Arrays.asList(consumirApiIngrediente.getForObject("http://localhost:9003/ingrediente/obtenerPorNombrePlato/" + plato.getNombrePlato(), IngredienteDto[].class));
        for (IngredienteDto ingrediente : listaIngredientes) {
            ingredientes.add(ingrediente.getNombreIngrediente());
        }
        plato.setIngredientes(ingredientes);
        platoRepository.save(plato);
    }

    @Override
    public void deletePlato(Long id) {
        platoRepository.deleteById(id);
    }

    @Override
    public Plato getPlatoById(Long id) {
        return platoRepository.findById(id).orElse(null);
    }

    @Override
    public Plato editPlato(Long id, Plato plato) {
        Plato platoEditado = this.getPlatoById(id);
        if (platoEditado != null) {
            platoEditado.setNombrePlato(plato.getNombrePlato());
            platoEditado.setPrecio(plato.getPrecio());
            platoEditado.setDescripcion(plato.getDescripcion());
            platoEditado.getIngredientes().addAll(plato.getIngredientes());
            this.savePlato(platoEditado);
            return this.getPlatoById(id);
        } else {
            return null;
        }
    }
}
