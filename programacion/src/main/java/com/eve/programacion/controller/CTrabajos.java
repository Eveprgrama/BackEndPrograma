
package com.eve.programacion.controller;

import com.eve.programacion.entity.Trabajos;
import com.eve.programacion.service.SvTrabajos;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("trabajos")
@CrossOrigin(origins = "http://localhost:4200")
@Transactional
public class CTrabajos {
    @Autowired SvTrabajos servtrab;
    
     @GetMapping("/lista")
    public List<Trabajos> getTrabajos() {
       return servtrab.getTrabajos();
    }
    
    @PostMapping ("/nueva")
    public String createTrabajos(@RequestBody Trabajos work) {
        servtrab.saveTrabajos(work);
        //devuelve un string avisando si creó correctamente
        return "El Trabajo fue creado correctamente";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String deleteTrabajos (@PathVariable int id){
        servtrab.deleteTrabajos(id);
        //devuelve un string avisando que borró correctamente
        return "El trabajo fue borrado correctamente";
    }
    
     @PutMapping("/editar/{id}")
	public Trabajos updateTrabajos(@PathVariable("id") int id, @RequestBody Trabajos trabajo) {
			Trabajos _trab = servtrab.findTrabajos(id);
                        _trab.setPagina(trabajo.getPagina());
			_trab.setCategoria(trabajo.getCategoria());
			_trab.setImagen(trabajo.getImagen());
			_trab.setFecha(trabajo.getFecha());
                        _trab.setUrl(trabajo.getUrl());
			servtrab.saveTrabajos(_trab);
                        return _trab;
		
	}
    
     @GetMapping("/detail/{id}")
    public ResponseEntity<Trabajos> getById(@PathVariable  int id) {
       if (!servtrab.existsById(id)){
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
       }
    Trabajos trab = servtrab.getOne(id).get();
    return new ResponseEntity(trab, HttpStatus.OK);
    }


    @GetMapping("mostrar")
    public Trabajos findTrabajos(@PathVariable int id) {
        return servtrab.findTrabajos(id);
    }
}
