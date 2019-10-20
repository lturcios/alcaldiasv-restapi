package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "giros")
public class Giro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long giroId;

    @NotBlank
    private String giroNombre;

    @ManyToOne
    @JoinColumn(name = "institucionId")
    private Institucion institucion;

}
