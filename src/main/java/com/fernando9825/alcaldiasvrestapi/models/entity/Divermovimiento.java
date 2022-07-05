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
@Table(name = "divermovimientos")
public class Divermovimiento {

    @Id
    @Size(min = 8, max = 10)
    private String pagoId;
    /*
     * llaves que tiene asignacion:
     *   contrib_id
     *   codigo_presupuestaria (de tarifa)
     *   InstitucionId*/
    @JsonIgnoreProperties(value = {
            "observaciones"
    })

    @ManyToOne
    @JoinColumn(name = "ubicacion_id_fk", referencedColumnName = "id")
    private Diverubicacion ubicacion;

    @NotNull
    private Integer codigoPresupuestario;

    @NotNull
    private double precioUnitario;

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
    private Diverusuario usuario;

    public Divermovimiento() {
    }

    public Divermovimiento(@Size(min = 8) String pagoId,
                          Diverubicacion ubicacion,
                          Integer codigoPresupuestario,
                          double precioUnitario,
                          Timestamp fechaHorapago,
                          @Size(max = 200) String observaciones,
                          @NotNull Diverusuario usuario,
                          @Size(min = 6, max = 12) String serieInicial,
                          @Size(min = 6, max = 12) String serieFinal) {
        this.pagoId = pagoId;
        this.ubicacion = ubicacion;
        this.codigoPresupuestario = codigoPresupuestario;
        this.precioUnitario = precioUnitario;
        this.fechaHorapago = fechaHorapago;
        this.observaciones = observaciones;
        this.usuario = usuario;
        this.serieInicial = serieInicial;
        this.serieFinal = serieFinal;
    }


    // getters and setters

    public String getPagoId() {
        return pagoId;
    }

    public void setPagoId(String pagoId) {
        this.pagoId = pagoId;
    }

    public Diverubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Diverubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getCodigoPresupuestario() { return codigoPresupuestario; }

    public void setCodigoPresupuestario(Integer codigoPresupuestario) { this.codigoPresupuestario = codigoPresupuestario; }

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

    public Diverusuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Diverusuario usuario) {
        this.usuario = usuario;
    }

}
