package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

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

    // llaves foraneas - relaciones
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Puesto> puestos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contribuyente> contribuyentes = new ArrayList<>();

    // lista de giros
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<Giro> giros = new ArrayList<>();

    // lista de tarifas
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<Tarifa> tarifas = new ArrayList<>();
}
