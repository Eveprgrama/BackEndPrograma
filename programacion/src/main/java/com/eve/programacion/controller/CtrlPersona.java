
package com.eve.programacion.controller;


import com.eve.programacion.entity.Persona;
import com.eve.programacion.service.ImpPersonaService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("personas")
@CrossOrigin(origins = "http://localhost:4200")
@Transactional
public class CtrlPersona {
    @Autowired 
    ImpPersonaService interPersona;
    
    @GetMapping("/traer")
    public List<Persona> getPersona() {
       return interPersona.getPersona();
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable ("id") Long id) {
       if (!interPersona.existsById(id)){
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
       }
    Persona perso = interPersona.getOne(id).get();
    return new ResponseEntity(perso, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/nueva")
    public String createPersona(@RequestBody Persona pers) {
        interPersona.savePersona(pers);
        //devuelve un string avisando si creó correctamente
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/borrar/{id}")
    public String deletePersona (@PathVariable Long id){
        interPersona.deletePersona(id);
        //devuelve un string avisando que borró correctamente
        return "La persona fue borrada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
	public Persona updatePersona(@PathVariable("id") Long id, @RequestBody Persona persona) {
			Persona _pers = interPersona.findPersona(id);
                        _pers.setNombre(persona.getNombre());
			_pers.setApellido(persona.getApellido());
			_pers.setImg(persona.getImg());
			_pers.setTitulo(persona.getTitulo());
			interPersona.savePersona(_pers);
                        return _pers;
		
	}
    
    @GetMapping("perfil")
    public Persona findPersona() {
        return interPersona.findPersona((long)1);
    }
}
