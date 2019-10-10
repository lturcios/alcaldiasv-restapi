package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Municipio;

import java.util.List;

public interface IMunicipioService {

    List<Municipio> findAll();

    Institucion findById(Long municipioId);

    Institucion save(Municipio municipio);

    void delete(Long municipioId);
}
