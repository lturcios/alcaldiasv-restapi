package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Saniubicacion;

import java.util.List;

public interface ISaniUbicacionService {

    List<Saniubicacion> findAll();

    List<Saniubicacion> findByInstitucionId(short institucionId);

    Saniubicacion findById(int saniubicacionId);

    Saniubicacion save(Saniubicacion saniubicacion);

    void delete(int saniubicacionId);

}
