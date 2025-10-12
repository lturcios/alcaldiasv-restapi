package com.fernando9825.alcaldiasvrestapi.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "turidetalles")
public class TuriDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "pago_id_fk", referencedColumnName = "pago_id", nullable = false)
    private TuriMovimiento pagoId;

    @Column(name = "codigo_presup", nullable = false)
    private int codigoPresupuestario;

    @Column(nullable = false)
    private int cantidad;

    @Column(name = "precio_unitario", nullable = false)
    private double precioUnitario;

    @Column(name = "precio_total", nullable = false)
    private double precioTotal;

    // getters and setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public TuriMovimiento getPagoId() {
        return pagoId;
    }
    public void setPagoId(TuriMovimiento pagoId) {
        this.pagoId = pagoId;
    }
    public int getCodigoPresupuestario() {
        return codigoPresupuestario;
    }
    public void setCodigoPresupuestario(int codigoPresupuestario) {
        this.codigoPresupuestario = codigoPresupuestario;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public double getPrecioTotal() {
        return precioTotal;
    }
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

}
