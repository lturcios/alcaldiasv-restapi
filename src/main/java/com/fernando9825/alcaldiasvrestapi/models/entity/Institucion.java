package com.fernando9825.alcaldiasvrestapi.models.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;

@Entity
@Table(name = "instituciones")
public class Institucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false)
    private String nombre;

    @NotBlank
    @Size(max = 125)
    @Column(nullable = false)
    private String direccion;

    @Size(max = 10)
    private String telefono;

    @NotBlank
    @Size(max = 10)
    @Column(nullable = false)
    private String estado;

    @NotNull
    private Time horaCorte;

    @Lob
    @Type(type="org.hibernate.type.ImageType")
    private byte[] imagen;

    @Lob
    @Type(type="org.hibernate.type.ImageType")
    private byte[] imagend;


    // getters and setters


    public Time getHoraCorte() {
        return horaCorte;
    }

    public void setHoraCorte(Time horaCorte) {
        this.horaCorte = horaCorte;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public byte[] getImagen() { return imagen; }

    public void setImagen(byte[] logo) { this.imagen = logo; }

    public byte[] getImagend() { return imagend; }

    public void setImagend(byte[] imagend) { this.imagend = imagend; }

}
