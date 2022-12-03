package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.DiverTarifa;

import java.util.List;

public interface IDiverTarifaService {

    List<DiverTarifa> getAllDiverTarifasByInstitucionId(short institucionId);

    List<DiverTarifa> getAllDiverTarifasByInstitucionIdAndUbicacion(short institucionId, int ubicacion);

}
