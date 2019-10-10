package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Institucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long institucionId;

    @NotBlank
    private String institucionNombre;

    @NotBlank
    private String institucionDireccion;

    private String institucionTelefono;

    @NotBlank
    private String institucionEstado;
}
