package com.restaurante.ingrediente.repository;

import com.restaurante.ingrediente.entity.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
    @Query("SELECT i FROM Ingrediente i WHERE :nombrePlato MEMBER OF i.platos")
    List<Ingrediente> findByNombre(String nombrePlato);
}
