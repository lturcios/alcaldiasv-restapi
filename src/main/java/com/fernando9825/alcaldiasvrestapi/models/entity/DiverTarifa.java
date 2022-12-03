package com.fernando9825.alcaldiasvrestapi.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "divertarifas")
public class DiverTarifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @NotNull
    @ManyToOne
    @JoinColumn(name = "institucion_id_fk", referencedColumnName = "id", nullable = false)
    private Institucion institucion;

    @NotNull
    @Column(name = "codigo_presup")
    private int codigoPresupuestario;

    @NotBlank
    @Size(max = 50)
    private String descripcion;

    @NotNull
    private double precioUnitario;

    @NotNull
    private double precioFiestas;

    @NotNull
    @Temporal(value = TemporalType.DATE)
    private Date vigencia;

    @Size(max = 200)
    private String referencia;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean vigente;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ubicacion_id_fk", referencedColumnName = "id")
    private DiverUbicacion ubicacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public int getCodigoPresupuestario() {
        return codigoPresupuestario;
    }

    public void setCodigoPresupuestario(int codigoPresupuestario) {
        this.codigoPresupuestario = codigoPresupuestario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public DiverUbicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(DiverUbicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
}
