package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.ITuriTarifaDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.ITuriUbicacionDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.InstitucionDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.TuriTarifa;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ITuriTarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuriTarifaImpl implements ITuriTarifaService {

    private final ITuriTarifaDao turiTarifaDao;
    private final InstitucionDao institucionDao;
    private final ITuriUbicacionDao turiUbicacionDao;

    @Autowired
    public TuriTarifaImpl(ITuriTarifaDao turiTarifaDao, InstitucionDao institucionDao, ITuriUbicacionDao turiUbicacionDao) {
        this.turiTarifaDao = turiTarifaDao;
        this.institucionDao = institucionDao;
        this.turiUbicacionDao = turiUbicacionDao;
    }

    @Override
    public List<TuriTarifa> getAllTuriTarifasByInstitucionIdAndUbicacion(short institucionId, int ubicacion) {
        return this.turiTarifaDao.findAllByInstitucionAndUbicacion(
                this.institucionDao.findById(institucionId).orElse(null),
                this.turiUbicacionDao.findById(ubicacion).orElse(null)
        );
    }
}
