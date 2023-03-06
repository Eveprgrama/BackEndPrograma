
package com.eve.programacion.repository;

import com.eve.programacion.entity.Trabajos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RTrabajos extends JpaRepository<Trabajos, Integer> {
    public Optional<Trabajos> findByCategoria(String categoria);
    public boolean existsByCategoria(String categoria);
    public Optional<Trabajos> findByPagina(String pagina);
    public boolean existsByPagina(String pagina);
}
