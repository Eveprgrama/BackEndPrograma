
package com.eve.programacion.repository;

import com.eve.programacion.entity.SobreMi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISobreMiRepository extends JpaRepository<SobreMi, Integer> {
    
}
