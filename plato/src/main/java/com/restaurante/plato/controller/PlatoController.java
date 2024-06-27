package com.restaurante.plato.controller;

import com.restaurante.plato.entity.Plato;
import com.restaurante.plato.service.PlatoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plato")
@AllArgsConstructor
public class PlatoController {

    private PlatoService platoService;

    @PostMapping("/crear")
    public ResponseEntity<String> crearPlato(@RequestBody Plato plato) {
        platoService.savePlato(plato);
        return ResponseEntity.ok("Plato creado correctamente");
    }

    @GetMapping("/obtenerTodo")
    public ResponseEntity<?> obtenerPlatos() {
        List<Plato> platos = platoService.getPlatos();
        if (platos.isEmpty() || platos == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(platos);
        }
    }
}
