package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.TuriTarifa;

import java.util.List;

public interface ITuriTarifaService {

    List<TuriTarifa> getAllTuriTarifasByInstitucionIdAndUbicacion(short institucionId, int ubicacion);

}
