package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "asignaciones")
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long asignacionId;

    @NotNull
    @Temporal(value = TemporalType.DATE)
    private Date fechaIngreso;

    @NotNull
    @Temporal(value = TemporalType.DATE)
    private Date ultimoPago;

    @Temporal(value = TemporalType.DATE)
    private Date fechaEgreso;

    private String observaciones;

    // llaves foraneas
    @ManyToOne
    @JoinColumn(name = "institucionId")
    private Institucion institucion;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contrib_id")
    private Contribuyente contribuyente;

    /*
        Este campo puede ser nulo, porque si en el futuro el vendedor deja el puesto
        debe haber la posibilidad de dejar el campo nulo, para que otro vendedor
        pueda tomar su lugar, y si le asigne el puesto
     */
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Puesto.class)
    @JoinColumn(name = "puesto_id", unique = true)
    private Puesto puesto;

    /*
    * Este campo se va actualizar automaticamente, si el vendedor, deja el puesto
    * registrando asi el puesto que tenia, y tambien se tomara la fecha en que dejó
    * el puesto (la fecha debe ser ingresada manualmente) */
    @ManyToOne
    @JoinColumn(referencedColumnName = "puesto_id")
    private Puesto puestoEgreso;

    @NotNull
    @Column(name = "codigo_presup")
    private Long codigoPresupuestario;

    @PreUpdate
    public void guardarUltimoPuesto(){
        if (this.puesto != null)
            setPuestoEgreso(this.puesto);
    }

    public Long getAsignacionId() {
        return asignacionId;
    }

    public void setAsignacionId(Long asignacionId) {
        this.asignacionId = asignacionId;
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
        this.ultimoPago = ultimoPago;
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

    public Contribuyente getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(Contribuyente contribuyente) {
        this.contribuyente = contribuyente;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Puesto getPuestoEgreso() {
        return puestoEgreso;
    }

    public void setPuestoEgreso(Puesto puestoEgreso) {
        this.puestoEgreso = puestoEgreso;
    }

    public Long getCodigoPresupuestario() {
        return codigoPresupuestario;
    }

    public void setCodigoPresupuestario(Long codigoPresupuestario) {
        this.codigoPresupuestario = codigoPresupuestario;
    }
}
