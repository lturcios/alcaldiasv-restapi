package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rutas")
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ruta_id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "institucionId")
    private Institucion institucion;

    // nombre de la ruta
    private String nombre;

    // descripcion de la ruta
    // por ejemplo, la ruta empiece desde la calle, que corta con ... hasta la avenida x
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Puesto> puestos = new ArrayList<>();

    // getters and setters


    public Long getRuta_id() {
        return ruta_id;
    }

    public void setRuta_id(Long ruta_id) {
        this.ruta_id = ruta_id;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Puesto> getPuestos() {
        return puestos;
    }

    public void setPuestos(List<Puesto> puestos) {
        this.puestos = puestos;
    }
}
