package com.fernando9825.alcaldiasvrestapi.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "parkmovimientos")
public class Parkmovimiento {

    @Id
    @Size(min = 8, max = 10)
    private String pagoId;

    @JsonIgnoreProperties(value = {
            "observacion"
    })
    @ManyToOne
    @JoinColumn(name = "ubicacion_id_fk", referencedColumnName = "id")
    private Parkubicacion ubicacion;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraentra;

    @Nullable
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHorasale;

    @NotNull
    private double precioUnitario;

    @Nullable
    private int tiempoMinutos;

    @Nullable
    private double montoTotal;

    @Nullable
    private String serieEntrada;

    @Nullable
    private String serieSalida;

    @Nullable
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHorapago;

    @Nullable
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraAnula;

    @Nullable
    @Size(max = 200)
    private String observaciones;

    @JsonIgnore
    @NotNull
    @OneToOne
    @JoinColumn(name = "usuario_email_fk")
    private Parkusuario usuario;


    /* Getters And Setters  */
    public String getPagoId() {
        return pagoId;
    }

    public void setPagoId(String pagoId) {
        this.pagoId = pagoId;
    }

    public Parkubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Parkubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFechaHoraentra() {
        return fechaHoraentra;
    }

    public void setFechaHoraentra(Date fechaHoraentra) {
        this.fechaHoraentra = fechaHoraentra;
    }

    @Nullable
    public Date getFechaHorasale() {
        return fechaHorasale;
    }

    public void setFechaHorasale(@Nullable Date fechaHorasale) {
        this.fechaHorasale = fechaHorasale;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getTiempoMinutos() {
        return tiempoMinutos;
    }

    public void setTiempoMinutos(int tiempoMinutos) {
        this.tiempoMinutos = tiempoMinutos;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    @Nullable
    public String getSerieEntrada() {
        return serieEntrada;
    }

    public void setSerieEntrada(@Nullable String serieEntrada) {
        this.serieEntrada = serieEntrada;
    }

    @Nullable
    public String getSerieSalida() {
        return serieSalida;
    }

    public void setSerieSalida(@Nullable String serieSalida) {
        this.serieSalida = serieSalida;
    }

    @Nullable
    public Date getFechaHorapago() {
        return fechaHorapago;
    }

    public void setFechaHorapago(@Nullable Date fechaHorapago) {
        this.fechaHorapago = fechaHorapago;
    }

    @Nullable
    public Date getFechaHoraAnula() {
        return fechaHoraAnula;
    }

    public void setFechaHoraAnula(@Nullable Date fechaHoraAnula) {
        this.fechaHoraAnula = fechaHoraAnula;
    }

    @Nullable
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(@Nullable String observaciones) {
        this.observaciones = observaciones;
    }

    public Parkusuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Parkusuario usuario) {
        this.usuario = usuario;
    }
}
