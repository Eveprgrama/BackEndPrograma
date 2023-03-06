
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
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String nombreE;
    @NotNull
    private String descripcionE;
    private String inicio;
    private String fin;
    private String localidad;
    private String img;
    
    
    public Experiencia() {
    }

    public Experiencia(int id, String nombreE, String descripcionE,  String inicio, String fin, String localidad, String img) {
        this.id = id;
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.inicio = inicio;
        this.fin = fin;
        this.localidad = localidad;
        this.img = img;
    }
    
    
}
