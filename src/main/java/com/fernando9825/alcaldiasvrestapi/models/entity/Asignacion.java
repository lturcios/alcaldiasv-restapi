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
    /*@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Institucion institucion;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Sector sector;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Giro giro;*/

    //@NotNull
    //@Column(name = "contrib_id")
    //@OneToMany(targetEntity = Contribuyente.class)
    //@JoinColumn(name = "fk_contrib_id", referencedColumnName = "contrib_id", table = "contribuyentes")
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


    @NotNull
    @Column(name = "codigo_presup")
    private Long codigoPresupuestario;


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

    /*public Contribuyente getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(Contribuyente contribuyente) {
        this.contribuyente = contribuyente;
    }*/

}
