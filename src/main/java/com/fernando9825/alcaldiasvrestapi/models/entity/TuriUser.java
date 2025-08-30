package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "turiusuarios")
public class TuriUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(max = 20)
    private String usuario;

    @NotBlank
    @NotNull
    @Size(min = 8, max = 120)
    private String nombre;

    @NotBlank
    @NotNull
    @Size(min = 6, max = 16)
    private String password;

    // llave foranea
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ubicacion_id_fk", referencedColumnName = "id")
    private TuriUbicacion ubicacion;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TuriUbicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(TuriUbicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
}
