package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sectorId;

    @NotBlank
    private String sectorNombre;

    // TODO
    // llave foranea de institucion
    private Long institucionId;

}
