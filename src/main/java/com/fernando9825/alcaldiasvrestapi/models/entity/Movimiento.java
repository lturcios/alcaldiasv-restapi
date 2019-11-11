package com.fernando9825.alcaldiasvrestapi.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "movimientos")
public class Movimiento {

    public Movimiento() {
    }

    public Movimiento(@Size(min = 8, max = 8) String pagoId, Asignacion asignacion, double precioUnitario, double tarifaUnitario, double iva, double montoTotal, @NotNull Date fechaInicio, Date fechaFin, Date fechaHorapago, @Size(max = 200) String observaciones, @NotNull Usuario usuario) {
        this.pagoId = pagoId;
        this.asignacion = asignacion;
        this.precioUnitario = precioUnitario;
        this.tarifaUnitario = tarifaUnitario;
        this.iva = iva;
        this.montoTotal = montoTotal;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaHorapago = fechaHorapago;
        this.observaciones = observaciones;
        this.usuario = usuario;
    }

    @Id
    @Size(min = 8, max = 8)
    private String pagoId;

    /*
    * llaves que tiene asignacion:
    *   contrib_id
    *   codigo_presupuestaria (de tarifa)
    *   InstitucionId*/
    @JsonIgnoreProperties(value = {
            "fechaIngreso",
            "ultimoPago",
            "fechaEgreso",
            "observaciones",
            "contribuyente",
            "puesto",
            "puestoEgreso",
            "codigoPresupuestario"
    })
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

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraAnula;

    @Size(max = 200)
    private String observaciones;



    @JsonIgnore
    @NotNull
    @OneToOne
    @JoinColumn(name = "usuario_email_fk")
    private Usuario usuario;


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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
