package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "instituciones")
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
