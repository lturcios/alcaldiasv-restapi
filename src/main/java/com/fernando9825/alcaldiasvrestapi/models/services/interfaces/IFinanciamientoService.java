package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Financiamiento;

import java.util.List;

public interface IFinanciamientoService {

    List<Financiamiento> findAll();

    Financiamiento findByInstitucionIdAndPuestoId(short institucionId, int puestoId);

    List<Financiamiento> findByInstitucionId(short institucionId);

    List<Financiamiento> findByInstitucionIdAndUsuarioEmail(short institucionId, String usuarioEmail);

    Financiamiento findById(int financiamientoId);

    Financiamiento findByContribuyenteId(int contribuyenteId);

    Financiamiento save(Financiamiento financiamiento);

    void delete(int financiamientoId);

}
