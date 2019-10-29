package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Table(name = "puestos")
public class Puesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "sector_id_fk", referencedColumnName = "id", nullable = false)
    private Sector sector;

    @ManyToOne
    @JoinColumn(name = "institucion_id_fk", referencedColumnName = "id", nullable = false)
    private Institucion institucion;

    @NotNull
    @PositiveOrZero
    private double medidaFrente;

    @NotNull
    @PositiveOrZero
    private double medidaFondo;

    @NotNull
    @PositiveOrZero
    private double medidaCompensa;

    @NotNull
    @PositiveOrZero
    private double medidaCalificacion;

    @NotBlank
    @Size(max = 10)
    private String modulo;

    @NotBlank
    @Size(max = 20)
    private String estado;


    // getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public double getMedidaFrente() {
        return medidaFrente;
    }

    public void setMedidaFrente(double medidaFrente) {
        this.medidaFrente = medidaFrente;
    }

    public double getMedidaFondo() {
        return medidaFondo;
    }

    public void setMedidaFondo(double medidaFondo) {
        this.medidaFondo = medidaFondo;
    }

    public double getMedidaCompensa() {
        return medidaCompensa;
    }

    public void setMedidaCompensa(double medidaCompensa) {
        this.medidaCompensa = medidaCompensa;
    }

    public double getMedidaCalificaion() {
        return medidaCalificacion;
    }

    public void setMedidaCalificaion(double medidaCalificaion) {
        this.medidaCalificacion = medidaCalificaion;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
