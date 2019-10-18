package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rutas")
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ruta_id;

    // nombre de la ruta
    private String nombre;

    // descripcion de la ruta
    // por ejemplo, la ruta empiece desde la calle, que corta con ... hasta la avenida x
    private String descripcion;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    //@JoinColumn(name = "puesto_id")
    private List<Puesto> puestos = new ArrayList<>();
}
