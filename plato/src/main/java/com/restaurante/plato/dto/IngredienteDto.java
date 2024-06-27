package com.restaurante.plato.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredienteDto {
    private Long idIngrediente;
    private String nombreIngrediente;
    private List<String> platos;
}
