package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Sector;

import java.util.List;

public interface ISectorService {

    List<Sector> findAll();

    Institucion findById(Long sectorId);

    Institucion save(Sector sector);

    void delete(Long sectorId);
}
