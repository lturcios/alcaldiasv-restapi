package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Sanitarifa;

import java.util.List;

public interface ISaniTarifaService {

    List<Sanitarifa> getAllSaniTarifasByInstitucionId(short institucionId);

    List<Sanitarifa> getAllSaniTarifasByInstitucionIdAndUbicacion(short institucionId, int ubicacion);

}
