package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.*;

@Entity
public class Puesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long puestoId;

    @OneToOne(cascade = CascadeType.ALL)
    private Sector sector;

    private String puestoModulo;

    private String puestoEstado;

    // llaves foraneas
    private Long institucionId;
    //private Long sectorId;
    private Long contribuyenteId;
}
