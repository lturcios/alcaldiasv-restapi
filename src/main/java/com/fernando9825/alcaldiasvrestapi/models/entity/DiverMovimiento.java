package com.fernando9825.alcaldiasvrestapi.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "divermovimientos")
public class DiverMovimiento {
    @Id
    @Size(min = 8, max = 10)
    private String pagoId;
    /*
     * llaves que tiene asignacion:
     *   contrib_id
     *   codigo_presupuestaria (de tarifa)
     *   InstitucionId*/
    @JsonIgnoreProperties(value = {
            "observaciones", "institucion"
    })
    @ManyToOne
    @JoinColumn(name = "ubicacion_id_fk", referencedColumnName = "id")
    private DiverUbicacion ubicacion;

    @NotNull
    @Column(name = "codigo_presup", nullable = false)
    private int codigoPresupuestario;

    @NotNull
    @Column(name = "referencia", nullable = false)
    private String referencia;

    @NotNull
    private double precioUnitario;

    @NotNull
    private double precioFiestas;

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

    @JsonIgnore
    @NotNull
    @OneToOne
    @JoinColumn(name = "usuario_email_fk")
    private Usuario usuario;

    public DiverMovimiento(){

    }

    public DiverMovimiento(String pagoId,
                           DiverUbicacion ubicacion,
                           int codigoPresupuestario,
                           String referencia,
                           double precioUnitario,
                           double precioFiestas,
                           Date fechaHorapago,
                           String observaciones,
                           @Nullable String serieInicial,
                           @Nullable String serieFinal,
                           Usuario usuario) {
        this.pagoId = pagoId;
        this.ubicacion = ubicacion;
        this.referencia = referencia;
        this.codigoPresupuestario = codigoPresupuestario;
        this.precioUnitario = precioUnitario;
        this.precioFiestas = precioFiestas;
        this.fechaHorapago = fechaHorapago;
        this.observaciones = observaciones;
        this.serieInicial = serieInicial;
        this.serieFinal = serieFinal;
        this.usuario = usuario;
    }

    public String getPagoId() {
        return pagoId;
    }

    public void setPagoId(String pagoId) {
        this.pagoId = pagoId;
    }

    public DiverUbicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(DiverUbicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCodigoPresupuestario() {
        return codigoPresupuestario;
    }

    public void setCodigoPresupuestario(int codigoPresupuestario) {
        this.codigoPresupuestario = codigoPresupuestario;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioFiestas() {
        return precioFiestas;
    }

    public void setPrecioFiestas(double precioFiestas) {
        this.precioFiestas = precioFiestas;
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

    @Nullable
    public String getSerieInicial() {
        return serieInicial;
    }

    public void setSerieInicial(@Nullable String serieInicial) {
        this.serieInicial = serieInicial;
    }

    @Nullable
    public String getSerieFinal() {
        return serieFinal;
    }

    public void setSerieFinal(@Nullable String serieFinal) {
        this.serieFinal = serieFinal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
