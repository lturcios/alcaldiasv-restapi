package com.fernando9825.alcaldiasvrestapi.models.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "tarifas")
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "institucion_id_fk", referencedColumnName = "id", nullable = false)
    private Institucion institucion;

    @NotNull
    @Column(name = "codigo_presup")
    private long codigoPresupuestario;

    @NotBlank
    private String descripcion;

    @NotNull
    private double precioUnitario;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy", iso = DateTimeFormat.ISO.NONE)
    @Temporal(value = TemporalType.DATE)
    private Date vigencia;

    private String referencia;


    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public long getCodigoPresupuestario() {
        return codigoPresupuestario;
    }

    public void setCodigoPresupuestario(long codigoPresupuestario) {
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
}
