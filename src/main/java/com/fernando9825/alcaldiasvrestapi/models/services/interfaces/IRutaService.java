package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Ruta;

import java.util.List;

public interface IRutaService {

    List<Ruta> findAll();

    Ruta findById(short rutaId);

    List<Ruta> findByInstitucionId(short institucionId);

    List<Ruta> findAllByInstitucionIdAndUsuarioEmail(short institucionId, String usuarioEmail);

    Ruta save(Ruta ruta);

    void delete(short rutaId);
}
