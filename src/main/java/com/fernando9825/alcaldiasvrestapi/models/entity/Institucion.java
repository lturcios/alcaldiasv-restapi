package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "institucion")
public class Institucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long institucionId;

//    @OneToOne(mappedBy = "institucion")
//    private Contribuyente contribuyente;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Contribuyente contribuyente;

    // lista de giros
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<Giro> giros = new ArrayList<>();

    @NotBlank
    private String institucionNombre;

    @NotBlank
    private String institucionDireccion;

    private String institucionTelefono;

    @NotBlank
    private String institucionEstado;
}
