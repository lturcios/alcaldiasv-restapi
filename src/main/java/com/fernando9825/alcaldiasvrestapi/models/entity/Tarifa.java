package com.fernando9825.alcaldiasvrestapi.models.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tarifaId;

    private String descripcion;

    @NotNull
    private double precioUnitario;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy", iso = DateTimeFormat.ISO.NONE)
    @Temporal(value = TemporalType.DATE)
    private Date vigencia;

    private String referencia;

}
