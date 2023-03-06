
package com.eve.programacion.repository;

import com.eve.programacion.entity.SoftSkill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RSoftSkill extends JpaRepository<SoftSkill, Integer> {
    public Optional<SoftSkill> findByHabilidad(String habilidad);
    public boolean existsByHabilidad(String habilidad);
}
