package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Asignacion;

import java.util.List;

public interface IAsignacionService {

    List<Asignacion> findAll();

    // Encontrar una sola asignacion
    Asignacion findByInstitucionIdAndPuestoId(short institucionId, int puestoId);

    // Todas las asignaciones
    List<Asignacion> findByInstitucionId(short institucionId);

    List<Asignacion> findByInstitucionIdAndUsuarioEmail(short institucionId, String usuarioEmail);

    Asignacion findById(int asignacionId);

    Asignacion save(Asignacion asignacion);

    void delete(int asignacionId);

}
