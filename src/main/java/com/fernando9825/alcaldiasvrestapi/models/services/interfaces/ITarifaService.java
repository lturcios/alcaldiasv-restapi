package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Tarifa;

import java.util.List;

public interface ITarifaService {

    List<Tarifa> getAllTarifasByInstitucion(short institucionId);
}
