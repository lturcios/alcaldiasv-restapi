package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.TuriUbicacion;

import java.util.List;

public interface ITuriUbicacionService {

    List<TuriUbicacion> findAll();

    List<TuriUbicacion> findByInstitucionId(short institucionId);

    TuriUbicacion findById(int turiubicacionId);

    TuriUbicacion save(TuriUbicacion turiUbicacion);

    void delete(int turiubicacionId);

}
