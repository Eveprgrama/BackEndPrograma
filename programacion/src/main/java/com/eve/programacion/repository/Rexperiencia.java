
package com.eve.programacion.repository;

import com.eve.programacion.entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rexperiencia extends JpaRepository<Experiencia, Integer> {
    public Optional<Experiencia> findByNombreE(String NombreE);
    public boolean existsByNombreE(String NombreE);
}
