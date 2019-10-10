package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;

@Entity
public class Contribuyente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contrib_id;

    @Column(name = "institucion_id")
    private short institucionId;

    @Column(name = "codigo_cta")
    private String codigoCuenta;

    @NotBlank
    @Size(min = 5, max = 255)
    private String nombres;

    @NotBlank
    @Size(min = 5, max = 255)
    private String apellidos;

    @Column(name = "dui")
    @Pattern(regexp = "[0-9]{8}-[0-9]")
    private String DUI;

    
    private String telefonoPrincipal;

    private String telefonoSecundario;

    @Column(name = "nit")
    private String NIT;

    @NotBlank
    @Size(min = 5, max = 255)
    private String direccion;

    @NotBlank
    @Size(min = 4, max = 20)
    private String departamento;

    private String municipioId;


    @Column(insertable = false, updatable = false, nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Calendar fechaCreacion;

    public long getContrib_id() {
        return contrib_id;
    }

    public void setContrib_id(long contrib_id) {
        this.contrib_id = contrib_id;
    }

    public short getInstitucionId() {
        return institucionId;
    }

    public void setInstitucionId(short institucionId) {
        this.institucionId = institucionId;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(String municipioId) {
        this.municipioId = municipioId;
    }

    public Calendar getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
