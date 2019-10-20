package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "instituciones")
public class Institucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long institucionId;

    @NotBlank
    private String institucionNombre;

    @NotBlank
    private String institucionDireccion;

    private String institucionTelefono;

    @NotBlank
    private String institucionEstado;

    public Long getInstitucionId() {
        return institucionId;
    }

    public void setInstitucionId(Long institucionId) {
        this.institucionId = institucionId;
    }

    public String getInstitucionNombre() {
        return institucionNombre;
    }

    public void setInstitucionNombre(String institucionNombre) {
        this.institucionNombre = institucionNombre;
    }

    public String getInstitucionDireccion() {
        return institucionDireccion;
    }

    public void setInstitucionDireccion(String institucionDireccion) {
        this.institucionDireccion = institucionDireccion;
    }

    public String getInstitucionTelefono() {
        return institucionTelefono;
    }

    public void setInstitucionTelefono(String institucionTelefono) {
        this.institucionTelefono = institucionTelefono;
    }

    public String getInstitucionEstado() {
        return institucionEstado;
    }

    public void setInstitucionEstado(String institucionEstado) {
        this.institucionEstado = institucionEstado;
    }
}
