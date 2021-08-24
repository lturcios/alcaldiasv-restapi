package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Servicio;

import java.util.List;

public interface IServicioService {

    List<Servicio> findAll();

    Servicio findByInstitucionIdAndPuestoId(short institucionId, int puestoId);

    List<Servicio> findByInstitucionIdAndUsuarioEmail(short institucionId, String usuarioEmail);

    List<Servicio> findByInstitucionId(short institucionId);

    Servicio findById(int servicioId);

    Servicio save(Servicio servicio);

    void delete(int servicioId);

}
