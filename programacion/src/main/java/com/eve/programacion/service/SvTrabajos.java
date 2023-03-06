
package com.eve.programacion.service;

import com.eve.programacion.entity.Trabajos;
import com.eve.programacion.repository.RTrabajos;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SvTrabajos {
    @Autowired RTrabajos rtrab;
    
       public List<Trabajos> getTrabajos() {
        List<Trabajos> trabajo = rtrab.findAll();
        return trabajo;
    }
    
    
    public Optional<Trabajos> getOne(int id){
         return rtrab.findById(id);
     }
    
     public Optional<Trabajos> getByPagina(String pagina){
         return rtrab.findByPagina(pagina);
     }
     
    
      public boolean existsById(int id){
         return rtrab.existsById(id);
     }
     
     public boolean existsByPagina(String pagina){
         return rtrab.existsByPagina(pagina);
     }

    
    public void saveTrabajos(Trabajos work) {
        rtrab.save(work);
    }

    
    public void deleteTrabajos(int id) {
        rtrab.deleteById(id);
    }

    
    public Trabajos findTrabajos(int id) {
        Trabajos estu = rtrab.findById(id).orElse(null);
        return estu;
    }
}
