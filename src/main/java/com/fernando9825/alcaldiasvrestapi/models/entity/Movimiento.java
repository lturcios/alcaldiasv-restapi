package com.fernando9825.alcaldiasvrestapi.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "movimientos")
public class Movimiento {

    public Movimiento() {
    }

    @Id
    @Size(min = 8, max = 10)
    private String pagoId;

    @Nullable
    private Double saldoActual;

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
    @JoinColumn(name = "asignacion_id_fk", referencedColumnName = "id")
    private Asignacion asignacion;

    @NotNull
    private double precioUnitario;

    @NotNull
    private double tarifaUnitario;

    @NotNull
    private double montoTotal;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHorapago;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraAnula;

    @Size(max = 200)
    private String observaciones;

    @Nullable
    private String serieInicial;

    @Nullable
    private String serieFinal;

    @Nullable
    private String tipo;

    @JsonIgnore
    @NotNull
    @OneToOne
    @JoinColumn(name = "usuario_email_fk")
    private Usuario usuario;

    @Nullable
    private Double saldoAnterior;

    public Movimiento(@Size(min = 8, max = 10) String pagoId,
                      Asignacion asignacion,
                      double precioUnitario,
                      double tarifaUnitario,
                      double montoTotal,
                      @NotNull Date fechaInicio,
                      Date fechaFin,
                      Timestamp fechaHorapago,
                      @Size(max = 200) String observaciones,
                      @NotNull Usuario usuario,
                      @Size(min = 6, max = 12) String serieInicial,
                      @Size(min = 6, max = 12) String serieFinal,
                      @Nullable Double saldoActual,
                      @Nullable Double saldoAnterior,
                      @Nullable String tipo) {
        this.pagoId = pagoId;
        this.asignacion = asignacion;
        this.precioUnitario = precioUnitario;
        this.tarifaUnitario = tarifaUnitario;
        this.montoTotal = montoTotal;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaHorapago = fechaHorapago;
        this.observaciones = observaciones;
        this.usuario = usuario;
        this.serieInicial = serieInicial;
        this.serieFinal = serieFinal;
        this.saldoActual = saldoActual;
        this.saldoAnterior = saldoAnterior;
        this.tipo = tipo;
    }

    public Date getFechaHorapago() {
        return fechaHorapago;
    }

    public void setFechaHorapago(Date fechaHorapago) {
        this.fechaHorapago = fechaHorapago;
    }

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

    public String getSerieInicial() {
        return serieInicial;
    }

    public void setSerieInicial(String serieInicial) {
        this.serieInicial = serieInicial;
    }

    public String getSerieFinal() {
        return serieFinal;
    }

    public void setSerieFinal(String serieFinal) {
        this.serieFinal = serieFinal;
    }

    @Nullable
    public Double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(@Nullable Double saldoActual) {
        this.saldoActual = saldoActual;
    }

    @Nullable
    public String getTipo() {
        return tipo;
    }

    public void setTipo(@Nullable String tipo) {
        this.tipo = tipo;
    }

    @Nullable
    public Double getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(@Nullable Double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

}
