package com.fernando9825.alcaldiasvrestapi.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "turimovimientos")
public class TuriMovimiento {
    @Id
    @Column(name = "pago_id", unique = true, nullable = false, length = 20)
    private String pagoId;

    @JsonIgnoreProperties(value = {
            "observaciones", "institucion", "descripcion", "observacion", "id"
    })
    @ManyToOne
    @JoinColumn(name = "ubicacion_id_fk", referencedColumnName = "id")
    private TuriUbicacion ubicacion;

    @Column(name = "referencia")
    private String referencia;

    @NotNull
    private double montoTotal;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHorapago;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraAnula;

    @Size(max = 200)
    private String observaciones;

    @Size(max = 20)
    private String numeroSerie;

    @JsonIgnore
    @NotNull
    @OneToOne
    @JoinColumn(name = "usuario_email_fk", referencedColumnName = "usuario")
    private TuriUser usuario;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pago_id_fk")
    private List<TuriDetalle> detalles = new ArrayList<>();

    public TuriMovimiento() {
    }

    public TuriMovimiento(
            String pagoId,
            TuriUbicacion ubicacion,
            @Nullable String referencia,
            double montoTotal,
            Date fechaHorapago,
            @Nullable Date fechaHoraAnula,
            @Nullable String observaciones,
            String numeroSerie,
            TuriUser usuario
    ) {
        this.pagoId = pagoId;
        this.ubicacion = ubicacion;
        this.referencia = referencia;
        this.montoTotal = montoTotal;
        this.fechaHorapago = fechaHorapago;
        this.fechaHoraAnula = fechaHoraAnula;
        this.observaciones = observaciones;
        this.numeroSerie = numeroSerie;
        this.usuario = usuario;
    }

    public String getPagoId() {
        return pagoId;
    }

    public void setPagoId(String pagoId) {
        this.pagoId = pagoId;
    }

    public TuriUbicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(TuriUbicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
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
    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(@Nullable String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public TuriUser getUsuario() {
        return usuario;
    }

    public void setUsuario(TuriUser usuario) {
        this.usuario = usuario;
    }

    public List<TuriDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<TuriDetalle> detalles) {
        this.detalles = detalles;
    }

}
