package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;

@Entity
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long asignacionId;

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
    private double areaCalificacion;

    @NotNull
    @Temporal(value = TemporalType.DATE)
    private Date fechaIngreso;

    @NotNull
    @Temporal(value = TemporalType.DATE)
    private Date ultimoPago;

    @Temporal(value = TemporalType.DATE)
    private Date fechaEgreso;

    private String observaciones;

    // llaves foraneas
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Institucion institucion;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Sector sector;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Giro giro;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Contribuyente contribuyente;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Tarifa tarifa;


    public Long getAsignacionId() {
        return asignacionId;
    }

    public void setAsignacionId(Long asignacionId) {
        this.asignacionId = asignacionId;
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

    public double getAreaCalificacion() {
        return areaCalificacion;
    }

    public void setAreaCalificacion(double areaCalificacion) {
        this.areaCalificacion = areaCalificacion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getUltimoPago() {
        return ultimoPago;
    }

    public void setUltimoPago(Date ultimoPago) {
        this.ultimoPago = ultimoPago;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Giro getGiro() {
        return giro;
    }

    public void setGiro(Giro giro) {
        this.giro = giro;
    }

    public Contribuyente getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(Contribuyente contribuyente) {
        this.contribuyente = contribuyente;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }
}
