package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Email
    @Size(max = 200)
    private String email;

    @NotBlank
    @NotNull
    @Size(min = 8, max = 120)
    private String nombre;

    @NotBlank
    @NotNull
    @Size(min = 8, max = 16)
    private String password;

    // llave foranea
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "institucion_id_fk", referencedColumnName = "id")
    private Institucion institucion;

    // getters and setters


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }
}
