package com.fernando9825.alcaldiasvrestapi.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "diverubicaciones")
public class Diverubicacion {    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

    @NotBlank
    @NotNull
    @Size(max = 50)
    private String descripcion;

    @Size(max = 200)
    private String observacion;


    @JsonIgnoreProperties(value = {
        "nombre", "direccion", "telefono",
            "estado", "horaCorte", "fiestas", "intereses",
            "imagen"
    })
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "institucion_id_fk", referencedColumnName = "id")
    private Institucion institucion;

    /* Getters and Setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }
}
