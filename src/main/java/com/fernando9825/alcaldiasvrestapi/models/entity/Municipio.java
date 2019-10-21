package com.fernando9825.alcaldiasvrestapi.models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "municipios")
public class Municipio {

    @Id
    private Integer id;

    @NotBlank
    @Size(min = 5)
    private String municipioDepartamento;


    // getters and setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMunicipioDepartamento() {
        return municipioDepartamento;
    }

    public void setMunicipioDepartamento(String municipioDepartamento) {
        this.municipioDepartamento = municipioDepartamento;
    }
}
