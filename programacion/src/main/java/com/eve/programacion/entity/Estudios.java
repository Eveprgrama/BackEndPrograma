
package com.eve.programacion.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Estudios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String inicio;
    private String fin;
    @NotNull
    private String instituto;
    private String especializacion;
    private String descripcion;
    private String img;
    
    
    public Estudios() {
    }

    public Estudios(int id, String inicio, String fin, String instituto, String especializacion, String descripcion, String img) {
        this.id = id;
        this.inicio = inicio;
        this.fin = fin;
        this.instituto = instituto;
        this.especializacion = especializacion;
        this.descripcion = descripcion;
        this.img = img;
    }
    
}
