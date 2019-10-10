package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Puesto;

import java.util.List;

public interface IPuestoService {

    List<Puesto> findAll();

    Institucion findById(Long puestoId);

    Institucion save(Puesto puesto);

    void delete(Long puestoId);
}
