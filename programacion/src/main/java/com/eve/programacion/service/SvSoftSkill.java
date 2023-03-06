
package com.eve.programacion.service;

import com.eve.programacion.entity.SoftSkill;
import com.eve.programacion.repository.RSoftSkill;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SvSoftSkill {
    @Autowired RSoftSkill rsoft;
    
     public List<SoftSkill> getSoftSkill() {
        List<SoftSkill> habilidades = rsoft.findAll();
        return habilidades;
    }
    
    
    public Optional<SoftSkill> getOne(int id){
         return rsoft.findById(id);
     }
    
     public Optional<SoftSkill> getByHabilidad(String habilidad){
         return rsoft.findByHabilidad(habilidad);
     }
     
    
      public boolean existsById(int id){
         return rsoft.existsById(id);
     }
     
     public boolean existsByHabilidad(String habilidad){
         return rsoft.existsByHabilidad(habilidad);
     }

    
    public void saveSoftSkill(SoftSkill soft) {
        rsoft.save(soft);
    }

    
    public void deleteSoftSkill(int id) {
        rsoft.deleteById(id);
    }

    
    public SoftSkill findSoftSkill(int id) {
        SoftSkill soft = rsoft.findById(id).orElse(null);
        return soft;
    }
}
