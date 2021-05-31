package com.fernando9825.alcaldiasvrestapi.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "asignaciones")
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date fechaIngreso;

    @Column(nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date ultimoPago;

    @Temporal(value = TemporalType.DATE)
    private Date fechaEgreso;

    @Size(max = 200)
    private String observaciones;

    // llaves foraneas
    @JsonIgnore // ignorar la institucion de la respuesta
    @ManyToOne
    @JoinColumn(name = "institucion_id_fk", referencedColumnName = "id", nullable = false)
    private Institucion institucion;


    //@JoinColumn(name = "contrib_id_fk", referencedColumnName = "id", nullable = false)
    @Column(name = "contrib_id_fk", nullable = false)
    private int contribuyente;

    /*
        Este campo puede ser nulo, porque si en el futuro el vendedor deja el puesto
        debe haber la posibilidad de dejar el campo nulo, para que otro vendedor
        pueda tomar su lugar, y si le asigne el puesto
     */
    @OneToOne(targetEntity = Puesto.class)
    @JoinColumn(name = "puesto_id_fk", referencedColumnName = "id", unique = true)
    private Puesto puesto;


    @OneToOne(targetEntity = Giro.class)
    @JoinColumn(name = "giro_id_fk", referencedColumnName = "id", nullable = false)
    private Giro giro;

    /*
    * Este campo se va actualizar automaticamente, si el vendedor, deja el puesto
    * registrando asi el puesto que tenia, y tambien se tomara la fecha en que dejó
    * el puesto (la fecha debe ser ingresada manualmente) */
    @ManyToOne
    @JoinColumn(name = "puesto_egreso_fk", referencedColumnName = "id")
    private Puesto puestoEgreso;

    @NotNull
    @Column(name = "codigo_presup", nullable = false)
    private int codigoPresupuestario;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getUltimoPago() {
        return ultimoPago;
    }

    public void setUltimoPago(Date ultimoPago) {
        if (ultimoPago.after(this.ultimoPago)) this.ultimoPago = ultimoPago;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public int getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(int contribuyente) {
        this.contribuyente = contribuyente;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Giro getGiro() {
        return giro;
    }

    public void setGiro(Giro giro) {
        this.giro = giro;
    }

    public Puesto getPuestoEgreso() {
        return puestoEgreso;
    }

    public void setPuestoEgreso(Puesto puestoEgreso) {
        this.puestoEgreso = puestoEgreso;
    }

    public int getCodigoPresupuestario() {
        return codigoPresupuestario;
    }

    public void setCodigoPresupuestario(int codigoPresupuestario) {
        this.codigoPresupuestario = codigoPresupuestario;
    }
}
