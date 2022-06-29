package com.fernando9825.alcaldiasvrestapi.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "impuestos")
public class Impuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "contrib_id_fk", nullable = false)
    private int contribuyenteId;

    @NotNull
    @Column(name = "codigo_presup", nullable = false)
    private int codigoPresupuestario;

    @Column(nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date fechaIngreso;

    @Temporal(value = TemporalType.DATE)
    private Date fechaEgreso;

    @Column(nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date ultimoPago;

    @Size(max = 200)
    private String observaciones;

    @OneToOne(targetEntity = Puesto.class)
    @JoinColumn(name = "puesto_id_fk", referencedColumnName = "id")
    private Puesto puesto;

    // llaves foraneas
    @JsonIgnore // ignorar la institucion de la respuesta
    @ManyToOne
    @JoinColumn(name = "institucion_id_fk", referencedColumnName = "id", nullable = false)
    private Institucion institucion;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContribuyenteId() {
        return contribuyenteId;
    }

    public void setContribuyenteId(int contribuyenteId) {
        this.contribuyenteId = contribuyenteId;
    }

    public int getCodigoPresupuestario() {
        return codigoPresupuestario;
    }

    public void setCodigoPresupuestario(int codigoPresupuestario) {
        this.codigoPresupuestario = codigoPresupuestario;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public Date getUltimoPago() {
        return ultimoPago;
    }

    public void setUltimoPago(Date ultimoPago) {
        if (ultimoPago.after(this.ultimoPago)) this.ultimoPago = ultimoPago;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }
}
