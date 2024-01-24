package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Parktarifa;

import java.util.List;

public interface IParkTarifaService {

    List<Parktarifa> getAllParkTarifasByInstitucionId(short institucionId);

    List<Parktarifa> getAllParkTarifasByInstitucionIdAndUbicacion(short institucionId, int ubicacion);

}
