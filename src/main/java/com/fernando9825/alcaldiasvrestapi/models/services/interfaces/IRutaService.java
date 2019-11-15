package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Ruta;

import java.util.List;

public interface IRutaService {

    List<Ruta> findAll();

    Ruta findById(Long rutaId);

    List<Ruta> findByInstitucionId(Long institucionId);

    List<Ruta> findByInstitucionIdAndUsuarioEmail(Long institucionId, String usuarioEmail);

    Ruta save(Ruta ruta);

    void delete(Long rutaId);
}
