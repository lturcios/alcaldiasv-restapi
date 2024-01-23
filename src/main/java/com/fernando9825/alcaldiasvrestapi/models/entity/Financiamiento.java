package com.fernando9825.alcaldiasvrestapi.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "financiamientos")
public class Financiamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "codigo_presup", nullable = false)
    private int codigoPresupuestario;

    //@JoinColumn(name = "contrib_id_fk", referencedColumnName = "id", nullable = false)
    @Column(name = "contrib_id_fk", nullable = false)
    private int contribuyenteId;

    @Column(nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date inicioPeriodo;

    @Column(nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date finalPeriodo;

    @Column(nullable = true)
    @Temporal(value = TemporalType.DATE)
    private Date pagadoPeriodo;

    @Column(nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date ultimoPago;

    @NotNull
    private double valorCuota;

    @Size(max = 200)
    private String observaciones;

    // llaves foraneas
    @JsonIgnore // ignorar la institucion de la respuesta
    @ManyToOne
    @JoinColumn(name = "institucion_id_fk", referencedColumnName = "id", nullable = false)
    private Institucion institucion;


    @OneToOne(targetEntity = Puesto.class)
    @JoinColumn(name = "puesto_id_fk", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {
            "estadi",
            "medidaCalificacion",
            "medidaCompensa",
            "medidaFondo",
            "medidaFrente",
            "modulo",
            "institucion",
            "sector"
    })
    private Puesto puesto;

    @NotNull
    private double saldoAnterior;

    @NotNull
    private double saldoActual;

// Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getInicioPeriodo() {
        return inicioPeriodo;
    }

    public void setInicioPeriodo(Date inicioPeriodo) {
        this.inicioPeriodo = inicioPeriodo;
    }

    public Date getFinalPeriodo() {
        return finalPeriodo;
    }

    public void setFinalPeriodo(Date finalPeriodo) {
        this.finalPeriodo = finalPeriodo;
    }

    public Date getPagadoPeriodo() {
        return pagadoPeriodo;
    }

    public void setPagadoPeriodo(Date pagadoPeriodo) {
        this.pagadoPeriodo = pagadoPeriodo;
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

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public int getContribuyenteId() {
        return contribuyenteId;
    }

    public void setContribuyenteId(int contribuyente) {
        this.contribuyenteId = contribuyente;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public int getCodigoPresupuestario() {
        return codigoPresupuestario;
    }

    public void setCodigoPresupuestario(int codigoPresupuestario) {
        this.codigoPresupuestario = codigoPresupuestario;
    }

    public double getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(double valorCuota) {
        this.valorCuota = valorCuota;
    }

    public double getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }
}
