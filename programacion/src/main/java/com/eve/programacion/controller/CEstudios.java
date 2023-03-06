
package com.eve.programacion.controller;

import com.eve.programacion.entity.Estudios;
import com.eve.programacion.service.SvEducacion;
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
@RequestMapping("estudios")
@CrossOrigin(origins = "http://localhost:4200")
@Transactional
public class CEstudios {
    @Autowired SvEducacion servedu;
    
     @GetMapping("/lista")
    public List<Estudios> getEstudios() {
       return servedu.getEstudios();
    }
    
    @PostMapping ("/nueva")
    public String createEstudios(@RequestBody Estudios est) {
        servedu.saveEstudios(est);
        //devuelve un string avisando si creó correctamente
        return "El estudio fue creado correctamente";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String deleteEstudios (@PathVariable int id){
        servedu.deleteEstudios(id);
        //devuelve un string avisando que borró correctamente
        return "El estudio fue borrado correctamente";
    }
    
   @PutMapping("/editar/{id}")
	public Estudios updateEstudios(@PathVariable("id") int id, @RequestBody Estudios estudios) {
			Estudios _estu = servedu.findEstudios(id);
                        _estu.setInstituto(estudios.getInstituto());
			_estu.setDescripcion(estudios.getDescripcion());
			_estu.setInicio(estudios.getInicio());
			_estu.setFin(estudios.getFin());
                        _estu.setEspecializacion(estudios.getEspecializacion());
                        _estu.setImg(estudios.getImg());
			servedu.saveEstudios(_estu);
                        return _estu;
		
	}
    
    @GetMapping("mostrar")
    public Estudios findEstudios(@PathVariable int id) {
        return servedu.findEstudios(id);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Estudios> getById(@PathVariable int id) {
       if (!servedu.existsById(id)){
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
       }
    Estudios estu = servedu.getOne(id).get();
    return new ResponseEntity(estu, HttpStatus.OK);
    }
    
}
