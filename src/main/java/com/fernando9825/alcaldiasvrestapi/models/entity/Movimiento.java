package com.fernando9825.alcaldiasvrestapi.models.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "movimientos")
public class Movimiento {

    @Id
    @Size(min = 8, max = 8)
    private String pagoId;


    @Column(name = "codigo_cta")
    //@OneToMany(targetEntity = Contribuyente.class)
    //@JoinColumn(name = "codigo_cta")
    private String codigoCuenta;

    @Column(name = "codigo_presup")
    private Long codigoPresupuestario;

    private double precioUnitario;

    private double tarifaUnitario;

    @Column(name = "valor_agregado")
    private double iva;

    private double montoTotal;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date fechaHorapago;

    private boolean pagoEstado;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraAnula;

    private String observaciones;

    private boolean actualizado;
}
