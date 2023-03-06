
package com.eve.programacion.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class SobreMi {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     
     @NotNull
     @Lob //almacenamos algo grande
     private String texto;
     @Lob
     private String imagen;

    public SobreMi(int id, String texto, String imagen) {
        this.id = id;
        this.texto = texto;
        this.imagen = imagen;
    }

    public SobreMi() {
    }
    
}
