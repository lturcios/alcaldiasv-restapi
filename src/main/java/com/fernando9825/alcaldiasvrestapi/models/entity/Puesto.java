package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Puesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long puestoId;

    private String puestoModulo;

    private String puestoEstado;

    // llaves foraneas
    private Long institucionId;
    private Long sectorId;
    private Long contribuyenteId;
}
