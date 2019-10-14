package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "sectores")
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sectorId;

    @NotBlank
    private String sectorNombre;

    // llave foranea de institucion

    @ManyToOne
    @JoinColumn(name = "institucionId")
    private Institucion institucion;

}
