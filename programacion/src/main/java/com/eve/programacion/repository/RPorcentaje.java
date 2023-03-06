
package com.eve.programacion.repository;

import com.eve.programacion.entity.Porcentaje;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RPorcentaje extends JpaRepository<Porcentaje, Integer> {
    public Optional<Porcentaje> findByTitulo(String Titulo);
    public boolean existsByTitulo(String Titulo);
}
