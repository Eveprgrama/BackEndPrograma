package com.eve.programacion.service;

import com.eve.programacion.entity.SobreMi;
import com.eve.programacion.repository.ISobreMiRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SvSobreMi {
    @Autowired ISobreMiRepository smi;
    
     
    public List<SobreMi> getSobreMi() {
        List<SobreMi> sobremi = smi.findAll();
        return sobremi;
    }
    
    
    public Optional<SobreMi> getOne(int id){
         return smi.findById(id);
     }
     
    
      public boolean existsById(int id){
         return smi.existsById(id);
     }
     

    
    public void saveSobreMi(SobreMi acerca) {
        smi.save(acerca);
    }

    
    public void deleteSobreMi(int id) {
        smi.deleteById(id);
    }

    
    public SobreMi findSobreMi(int id) {
        SobreMi acerca = smi.findById(id).orElse(null);
        return acerca;
    }
    
}
    
    

