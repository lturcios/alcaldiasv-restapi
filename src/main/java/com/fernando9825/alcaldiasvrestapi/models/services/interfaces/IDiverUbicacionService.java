package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Diverubicacion;

import java.util.List;

public interface IDiverUbicacionService {

    List<Diverubicacion> findAll();

    List<Diverubicacion> findByInstitucionId(short institucionId);

    Diverubicacion findById(int diverubicacionId);

    Diverubicacion save(Diverubicacion diverubicacion);

    void delete(int diverubicacionId);

}
