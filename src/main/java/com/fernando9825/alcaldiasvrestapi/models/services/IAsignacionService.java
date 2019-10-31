package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.entity.Asignacion;

import java.util.List;

public interface IAsignacionService {

    List<Asignacion> findAll();

    // Encontrar una sola asignacion
    Asignacion findByInstitucionIdAndPuestoId(Long institucionId, Long puestoId);

    Asignacion findById(Long asignacionId);

    Asignacion save(Asignacion asignacion);

    void delete(Long asignacionId);

}
