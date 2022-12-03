package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.DiverUbicacion;

import java.util.List;

public interface IDiverUbicacionService {

    List<DiverUbicacion> findAll();

    List<DiverUbicacion> findByInstitucionId(short institucionId);

    DiverUbicacion findById(int diverubicacionId);

    DiverUbicacion save(DiverUbicacion diverUbicacion);

    void delete(int diverubicacionId);

}
