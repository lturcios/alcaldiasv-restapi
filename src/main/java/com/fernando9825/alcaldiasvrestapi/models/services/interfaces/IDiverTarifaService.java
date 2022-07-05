package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Divertarifa;

import java.util.List;

public interface IDiverTarifaService {

    List<Divertarifa> getAllDiverTarifasByInstitucionId(short institucionId);

    List<Divertarifa> getAllDiverTarifasByInstitucionIdAndUbicacion(short institucionId, int ubicacion);
}
