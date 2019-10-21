package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "giros")
public class Giro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long giroId;

    @NotBlank
    private String giroNombre;

    @ManyToOne
    @JoinColumn(name = "institucionId")
    private Institucion institucion;

    public Long getGiroId() {
        return giroId;
    }

    public void setGiroId(Long giroId) {
        this.giroId = giroId;
    }

    public String getGiroNombre() {
        return giroNombre;
    }

    public void setGiroNombre(String giroNombre) {
        this.giroNombre = giroNombre;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }
}
