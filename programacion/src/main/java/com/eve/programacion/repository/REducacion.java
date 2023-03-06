
package com.eve.programacion.repository;

import com.eve.programacion.entity.Estudios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface REducacion extends JpaRepository<Estudios, Integer> {
    public Optional<Estudios> findByInstituto(String Instituto);
    public boolean existsByInstituto(String Instituto);
}
