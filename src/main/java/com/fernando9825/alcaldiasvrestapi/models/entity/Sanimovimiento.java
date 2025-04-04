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
@Table(name = "sanimovimientos")
public class Sanimovimiento {

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
    private Saniubicacion ubicacion;

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
    private Saniusuario usuario;

    @Size(max = 10)
    private String genero;

    public Sanimovimiento() {
    }

    public Sanimovimiento(@Size(min = 8) String pagoId,
                          Saniubicacion ubicacion,
                          double precioUnitario,
                          Timestamp fechaHorapago,
                          @Size(max = 200) String observaciones,
                          @NotNull Saniusuario usuario,
                          @Size(min = 6, max = 12) String serieInicial,
                          @Size(min = 6, max = 12) String serieFinal,
                          @Size(max = 10) String genero) {
        this.pagoId = pagoId;
        this.ubicacion = ubicacion;
        this.precioUnitario = precioUnitario;
        this.fechaHorapago = fechaHorapago;
        this.observaciones = observaciones;
        this.usuario = usuario;
        this.serieInicial = serieInicial;
        this.serieFinal = serieFinal;
        this.genero = genero;
    }


    // getters and setters

    public String getPagoId() {
        return pagoId;
    }

    public void setPagoId(String pagoId) {
        this.pagoId = pagoId;
    }

    public Saniubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Saniubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
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

    public Saniusuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Saniusuario usuario) {
        this.usuario = usuario;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
