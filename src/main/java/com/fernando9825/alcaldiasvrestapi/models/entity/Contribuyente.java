package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "contribuyentes")
public class Contribuyente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contribId;

    //@OneToMany
//    @JoinTable(
//            name = "course_like",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_id"))
    //private Set<Asignacion> asignaciones;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contribuyente")
    private List<Asignacion> asignaciones;


    @Column(name = "codigo_cta", unique = true)
    private String codigoCuenta;

    @NotBlank
    @Size(min = 5, max = 255)
    private String nombres;

    @NotBlank
    @Size(min = 5, max = 255)
    private String apellidos;

    @Column(name = "dui", unique = true)
    @Pattern(regexp = "[0-9]{8}-[0-9]")
    private String DUI;

    private String telefonoPrincipal;

    private String telefonoSecundario;

    @Column(name = "nit")
    private String NIT;

    @NotBlank
    @Size(min = 5, max = 255)
    private String direccion;

    @Column(insertable = false, updatable = false, nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Calendar fechaCreacion;

    // LLAVES FORANEAS

    /*
    * Esta llave la deje de modo de que un contribuyente, pueda tener
    * o estar vinculado a muchas instituciones, por si acaso, existe algun
    * vendedor que sea empresario con puestos asignados en varias alcaldias*/
    @NotNull
    @ManyToOne
    @JoinColumn(name = "institucionId")
    private Institucion institucion;

    @OneToOne
    @JoinColumn(name = "municipioId")
    @NotNull
    private Municipio municipio;

    // getters and setters

    public long getContribId() {
        return contribId;
    }

    public void setContribId(long contribId) {
        this.contribId = contribId;
    }

    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public String getTelefonoPrincipal() {
        return telefonoPrincipal;
    }

    public void setTelefonoPrincipal(String telefonoPrincipal) {
        this.telefonoPrincipal = telefonoPrincipal;
    }

    public String getTelefonoSecundario() {
        return telefonoSecundario;
    }

    public void setTelefonoSecundario(String telefonoSecundario) {
        this.telefonoSecundario = telefonoSecundario;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Calendar getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}
