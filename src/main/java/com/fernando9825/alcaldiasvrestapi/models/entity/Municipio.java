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
    private Long municipioId;

    @NotBlank
    @Size(min = 5)
    private String municipioDepartamento;
}
