
package com.eve.programacion.service;

import com.eve.programacion.entity.Persona;
import com.eve.programacion.repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService {
    @Autowired IPersonaRepository personarep;

   
    public List<Persona> getPersona() {
        List<Persona> listapersonas = personarep.findAll();
        return listapersonas;
    }

    
    public void savePersona(Persona pers) {
        personarep.save(pers);
    }

    
    public void deletePersona(Long id) {
        personarep.deleteById(id);
    }

  
    public Persona findPersona(Long id) {
        Persona pers = personarep.findById(id).orElse(null);
       return pers;
    }
    
   
    public boolean existsById(Long id){
        return personarep.existsById(id);
    }
    
    public Optional <Persona> getOne(Long id){
        return personarep.findById(id);
    }

    
}
