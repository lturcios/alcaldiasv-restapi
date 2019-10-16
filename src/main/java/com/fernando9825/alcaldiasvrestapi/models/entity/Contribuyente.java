package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "contribuyentes")
public class Contribuyente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contribId;

    @Column(name = "codigo_cta")
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

    @ManyToOne
    @JoinColumn(name = "institucionId")
    private Institucion institucion;

    @OneToOne
    @JoinColumn(name = "municipioId")
    @NotNull
    private Municipio municipio;

    /*@OneToMany(mappedBy = "contribuyente")
    private List<Puesto> puestos = new ArrayList<>();*/


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
