package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "municipios")
public class Municipio {

    @Id
    private short id;

    @NotNull
    @Size(min = 5, max = 50)
    private String municipioDepartamento;


    // getters and setters


    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getMunicipioDepartamento() {
        return municipioDepartamento;
    }

    public void setMunicipioDepartamento(String municipioDepartamento) {
        this.municipioDepartamento = municipioDepartamento;
    }
}
