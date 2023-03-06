
package com.eve.programacion.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
  private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
  private String apellido;
    
    @Lob //anotación para objeto grande
  private String img;
  
  @NotNull
    @Size(min = 1, max = 400, message = "no cumple con la longitud")
  private String titulo;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String img, String titulo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.titulo = titulo;
    }
  
}
