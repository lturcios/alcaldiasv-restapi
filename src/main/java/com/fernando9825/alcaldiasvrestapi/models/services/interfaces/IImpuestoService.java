package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Impuesto;

import java.util.List;

public interface IImpuestoService {

    List<Impuesto> findAll();

    Impuesto findByInstitucionIdAndPuestoId(short institucionId, int puestoId);

    List<Impuesto> findByInstitucionIdAndUsuarioEmail(short institucionId, String usuarioEmail);

    List<Impuesto> findByInstitucionId(short institucionId);

    Impuesto findById(int impuestoId);

    Impuesto save(Impuesto impuesto);

    void delete(int impuestoId);
}
