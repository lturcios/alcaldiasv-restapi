package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;

@Entity
public class Contribuyente implements Serializable {

    @Id
    @Pattern(regexp = "[0-9]{8}-[0-9]")
    private String DUI;

    @NotBlank
    @Size(min = 5, max = 255)
    private String nombre;

    @NotBlank
    @Size(min = 5, max = 255)
    private String direccion;

    @NotBlank
    @Size(min = 4, max = 20)
    private String departamento;

    @NotNull
    private double impuesto;

    // these values are expressed in meters
    private double anchoLocal;
    private double largoLocal;

    @Column(insertable = false, updatable = false, nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Calendar fechaCreacion;

    public Calendar getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getAnchoLocal() {
        return anchoLocal;
    }

    public void setAnchoLocal(double anchoLocal) {
        this.anchoLocal = anchoLocal;
    }

    public double getLargoLocal() {
        return largoLocal;
    }

    public void setLargoLocal(double largoLocal) {
        this.largoLocal = largoLocal;
    }
}
