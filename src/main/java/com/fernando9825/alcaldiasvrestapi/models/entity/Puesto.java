package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "puestos")
public class Puesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long puestoId;

    @OneToOne(cascade = CascadeType.ALL)
    private Sector sector;

    private String puestoModulo;

    private String puestoEstado;

    @ManyToOne
    @JoinColumn(name = "institucionId", nullable = false)
    private Institucion institucion;

    @ManyToOne
    @JoinColumn(name="contribId")
    private Contribuyente contribuyente;

    // getters and setters


    public Long getPuestoId() {
        return puestoId;
    }

    public void setPuestoId(Long puestoId) {
        this.puestoId = puestoId;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getPuestoModulo() {
        return puestoModulo;
    }

    public void setPuestoModulo(String puestoModulo) {
        this.puestoModulo = puestoModulo;
    }

    public String getPuestoEstado() {
        return puestoEstado;
    }

    public void setPuestoEstado(String puestoEstado) {
        this.puestoEstado = puestoEstado;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public Contribuyente getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(Contribuyente contribuyente) {
        this.contribuyente = contribuyente;
    }
}
