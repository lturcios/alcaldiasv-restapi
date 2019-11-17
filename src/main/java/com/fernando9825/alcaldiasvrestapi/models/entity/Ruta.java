package com.fernando9825.alcaldiasvrestapi.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rutas")
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @JsonIgnore
    @NotNull
    @ManyToOne
    @JoinColumn(name = "institucion_id_fk", referencedColumnName = "id")
    private Institucion institucion;


    // cuando el usuario no tenga asignada ninguna ruta se le van a mostrar todas
    @JsonIgnore
    @Email
    @Size(max = 200)
    @ManyToOne
    @JoinColumn(name = "usuario_email_fk", referencedColumnName = "email", nullable = true)
    private Usuario usuario;

    // nombre de la ruta
    @NotNull
    @Size(max = 25)
    @Column(nullable = false)
    private String nombre;

    // descripcion de la ruta
    // por ejemplo, la ruta empiece desde la calle, que corta con ... hasta la avenida x
    @Size(max = 50)
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Puesto> puestos = new ArrayList<>();

    // getters and setters


    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Puesto> getPuestos() {
        return puestos;
    }

    public void setPuestos(List<Puesto> puestos) {
        this.puestos = puestos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
