package com.restaurante.plato.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlato;
    private String nombrePlato;
    private Double precio;
    private String descripcion;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> ingredientes;
}
