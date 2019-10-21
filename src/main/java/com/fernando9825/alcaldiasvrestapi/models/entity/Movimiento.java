package com.fernando9825.alcaldiasvrestapi.models.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "movimientos")
public class Movimiento {

    @Id
    @Size(min = 8, max = 8)
    private String pagoId;


    /*
    * llaves que tiene asignacion:
    *   contrib_id
    *   codigo_presupuestaria (de tarifa)
    *   InstitucionId*/
    @ManyToOne
    @JoinColumn(name = "asignacion_id_fk", referencedColumnName = "id", nullable = false)
    private Asignacion asignacion;

    private double precioUnitario;

    private double tarifaUnitario;

    @Column(name = "valor_agregado")
    private double iva;

    private double montoTotal;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date fechaHorapago;

    private boolean pagoEstado;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraAnula;

    private String observaciones;

    private boolean actualizado;


    // getters and setters
    public String getPagoId() {
        return pagoId;
    }

    public void setPagoId(String pagoId) {
        this.pagoId = pagoId;
    }

    public Asignacion getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(Asignacion asignacion) {
        this.asignacion = asignacion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getTarifaUnitario() {
        return tarifaUnitario;
    }

    public void setTarifaUnitario(double tarifaUnitario) {
        this.tarifaUnitario = tarifaUnitario;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaHorapago() {
        return fechaHorapago;
    }

    public void setFechaHorapago(Date fechaHorapago) {
        this.fechaHorapago = fechaHorapago;
    }

    public boolean isPagoEstado() {
        return pagoEstado;
    }

    public void setPagoEstado(boolean pagoEstado) {
        this.pagoEstado = pagoEstado;
    }

    public Date getFechaHoraAnula() {
        return fechaHoraAnula;
    }

    public void setFechaHoraAnula(Date fechaHoraAnula) {
        this.fechaHoraAnula = fechaHoraAnula;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean isActualizado() {
        return actualizado;
    }

    public void setActualizado(boolean actualizado) {
        this.actualizado = actualizado;
    }
}
