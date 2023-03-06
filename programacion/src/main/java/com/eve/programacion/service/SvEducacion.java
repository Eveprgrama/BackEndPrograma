
package com.eve.programacion.service;

import com.eve.programacion.entity.Estudios;
import com.eve.programacion.repository.REducacion;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SvEducacion {
    @Autowired REducacion repedu;

    public List<Estudios> getEstudios() {
        List<Estudios> estudio = repedu.findAll();
        return estudio;
    }
    
    
    public Optional<Estudios> getOne(int id){
         return repedu.findById(id);
     }
    
     public Optional<Estudios> getByInstituto(String Instituto){
         return repedu.findByInstituto(Instituto);
     }
     
    
      public boolean existsById(int id){
         return repedu.existsById(id);
     }
     
     public boolean existsByInstituto(String Instituto){
         return repedu.existsByInstituto(Instituto);
     }

    
    public void saveEstudios(Estudios est) {
        repedu.save(est);
    }

    
    public void deleteEstudios(int id) {
        repedu.deleteById(id);
    }

    
    public Estudios findEstudios(int id) {
        Estudios estu = repedu.findById(id).orElse(null);
        return estu;
    }
    
}
    