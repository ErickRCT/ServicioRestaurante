package com.restaurante.ingrediente.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIngrediente;
    private String nombreIngrediente;
    //la entidad Ingrediente tendra una lista
    //solamente con los nombres de los platos
    //en los que es usado
    @ElementCollection
    private List<String> platos;
}
