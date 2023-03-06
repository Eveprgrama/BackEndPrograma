
package com.eve.programacion.service;

import com.eve.programacion.entity.Experiencia;
import com.eve.programacion.repository.Rexperiencia;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SvExperiencia {

    @Autowired Rexperiencia repexp;

    
    
    public List<Experiencia> getExperiencia() {
        List<Experiencia> experiencias = repexp.findAll();
        return experiencias;
    }
    
    
    public Optional<Experiencia> getOne(int id){
         return repexp.findById(id);
     }
    
     public Optional<Experiencia> getByNombreE(String nombreE){
         return repexp.findByNombreE(nombreE);
     }
     
    
      public boolean existsById(int id){
         return repexp.existsById(id);
     }
     
     public boolean existsByNombreE(String nombreE){
         return repexp.existsByNombreE(nombreE);
     }

    
    public void saveExperiencia(Experiencia exp) {
        repexp.save(exp);
    }

    
    public void deleteExperiencia(int id) {
        repexp.deleteById(id);
    }

    
    public Experiencia findExperiencia(int id) {
        Experiencia expe = repexp.findById(id).orElse(null);
        return expe;
    }
    
}
    