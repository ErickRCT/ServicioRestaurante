package com.restaurante.ingrediente.controller;

import com.restaurante.ingrediente.entity.Ingrediente;
import com.restaurante.ingrediente.service.IngredienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingrediente")
@AllArgsConstructor
public class IngredienteController {

    private IngredienteService ingredienteService;

    @PostMapping("/crear")
    public ResponseEntity<String> crearIngrediente(@RequestBody Ingrediente ingrediente) {
        ingredienteService.saveIngrediente(ingrediente);
        return ResponseEntity.ok("Ingrediente creado correctamente");
    }

    @GetMapping("/obtenerPorNombrePlato/{nombrePlato}")
    public List<Ingrediente> obtenerIngredientePorNombrePlato(@PathVariable String nombrePlato) {
        return ingredienteService.findIngredienteByNamePlato(nombrePlato);
    }

    @GetMapping("/obtenerTodo")
    public ResponseEntity<?> obtenerIngrediente() {
        List<Ingrediente> ingredientes = ingredienteService.getIngredientes();
        if (ingredientes.isEmpty() || ingredientes == null){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(ingredientes);
        }
    }
}
