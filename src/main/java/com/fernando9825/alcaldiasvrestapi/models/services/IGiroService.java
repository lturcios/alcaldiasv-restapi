package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.entity.Giro;
import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;

import java.util.List;

public interface IGiroService {

    List<Giro> findAll();

    Institucion findById(Long giroId);

    Institucion save(Giro giro);

    void delete(Long giroId);
}
