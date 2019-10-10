package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;

import java.util.List;

public interface InstitucionInterfaceService {

    List<Institucion> findAll();

    Institucion findById(Long institucionId);

    Institucion save(Institucion institucion);

    void delete(Long institucionId);
}
