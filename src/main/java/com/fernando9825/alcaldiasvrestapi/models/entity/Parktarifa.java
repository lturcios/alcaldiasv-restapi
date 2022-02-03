package com.fernando9825.alcaldiasvrestapi.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "parktarifas")
public class Parktarifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // ignorar la institucion de la respuesta
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

    @NotBlank
    @Size(max = 6)
    private String periodo;

    @NotNull
    //@DateTimeFormat(pattern = "dd/MM/yyyy", iso = DateTimeFormat.ISO.NONE)
    @Temporal(value = TemporalType.DATE)
    private Date vigencia;

    @Size(max = 200)
    private String referencia;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean vigente;

    // llave foranea
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ubicacion_id_fk", referencedColumnName = "id")
    private Parkubicacion ubicacion;

    @NotNull
    private int iconfile;

    /* Getters And Setters */
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

    public String getPeriodo() { return periodo; }

    public void setPeriodo(String periodo) { this.periodo = periodo; }

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

    public Parkubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Parkubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getIconfile() { return iconfile; }
    public void setIconfile(int iconfile) { this.iconfile = iconfile; }

}
