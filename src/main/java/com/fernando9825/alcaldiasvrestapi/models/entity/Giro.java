package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Giro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long giroId;

    @NotBlank
    private String giroNombre;

    // llave foranea
    private Long institucionId;
}
