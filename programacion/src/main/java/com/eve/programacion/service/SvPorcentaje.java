
package com.eve.programacion.service;

import com.eve.programacion.entity.Porcentaje;
import com.eve.programacion.repository.RPorcentaje;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SvPorcentaje {
    @Autowired RPorcentaje repor;
    
     public List<Porcentaje> getPorcentaje() {
        List<Porcentaje> porcentajes = repor.findAll();
        return porcentajes;
    }
    
    
    public Optional<Porcentaje> getOne(int id){
         return repor.findById(id);
     }
    
     public Optional<Porcentaje> getByTitulo(String titulo){
         return repor.findByTitulo(titulo);
     }
     
    
      public boolean existsById(int id){
         return repor.existsById(id);
     }
     
     public boolean existsByTitulo(String titulo){
         return repor.existsByTitulo(titulo);
     }

    
    public void savePorcentaje(Porcentaje por) {
        repor.save(por);
    }

    
    public void deletePorcentaje(int id) {
        repor.deleteById(id);
    }

    
    public Porcentaje findPorcentaje(int id) {
        Porcentaje porce = repor.findById(id).orElse(null);
        return porce;
    }
}
