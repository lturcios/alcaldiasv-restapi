package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IDiverTarifaDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.IDiverUbicacionDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.InstitucionDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.DiverTarifa;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IDiverTarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiverTarifaImpl implements IDiverTarifaService {

    private final IDiverTarifaDao diverTarifaDao;
    private final InstitucionDao institucionDao;
    private final IDiverUbicacionDao diverUbicacionDao;
    @Autowired
    public DiverTarifaImpl(
            IDiverTarifaDao diverTarifaDao,
            InstitucionDao institucionDao,
            IDiverUbicacionDao diverUbicacionDao
    ) {
        this.diverTarifaDao = diverTarifaDao;
        this.institucionDao = institucionDao;
        this.diverUbicacionDao = diverUbicacionDao;
    }


    @Override
    public List<DiverTarifa> getAllDiverTarifasByInstitucionId(short institucionId) {
        return this.diverTarifaDao.findAllByInstitucion(
                this.institucionDao.findById(institucionId).orElse(null)
        );
    }

    @Override
    public List<DiverTarifa> getAllDiverTarifasByInstitucionIdAndUbicacion(short institucionId, int ubicacion) {
        return this.diverTarifaDao.findAllByInstitucionAndUbicacion(
                this.institucionDao.findById(institucionId).orElse(null),
                this.diverUbicacionDao.findById(ubicacion).orElse(null)
        );
    }
}
