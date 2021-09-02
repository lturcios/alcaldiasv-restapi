package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Parkubicacion;

import java.util.List;

public interface IParkUbicacionService {

    List<Parkubicacion> findAll();

    List<Parkubicacion> findByInstitucionId(short institucionId);

    Parkubicacion findById(short parkubicacionId);

    Parkubicacion save(Parkubicacion parkubicacion);

    void delete(short parkubicacionId);

}
