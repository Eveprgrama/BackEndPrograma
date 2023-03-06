
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
public class Trabajos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String imagen;
    @NotNull
    private String pagina;
    @NotNull
    private String categoria;
    private String fecha;
    private String url;

    public Trabajos() {
    }

    public Trabajos(int id, String imagen, String pagina, String categoria, String fecha, String url) {
        this.id = id;
        this.imagen = imagen;
        this.pagina = pagina;
        this.categoria = categoria;
        this.fecha = fecha;
        this.url = url;
    }
    
}
