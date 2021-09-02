package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.ISaniTarifaDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.ISaniUbicacionDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.InstitucionInterfaceService;
import com.fernando9825.alcaldiasvrestapi.models.entity.Sanitarifa;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ISaniTarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaniTarifaImpl implements ISaniTarifaService {

    private final ISaniTarifaDao saniTarifaDao;
    private final InstitucionInterfaceService institucionDao;
    private final ISaniUbicacionDao saniubicacionDao;

    @Autowired
    public SaniTarifaImpl(
            ISaniTarifaDao saniTarifaDao,
            InstitucionInterfaceService institucionDao,
            ISaniUbicacionDao saniubicacionDao
    ){
        this.saniTarifaDao = saniTarifaDao;
        this.institucionDao = institucionDao;
        this.saniubicacionDao = saniubicacionDao;
    }

    @Override
    public List<Sanitarifa> getAllSaniTarifasByInstitucionId(short institucionId) {
        return this.saniTarifaDao.findAllByInstitucion(
                this.institucionDao.findById(institucionId).orElse(null)
        );
    }

    @Override
    public List<Sanitarifa> getAllSaniTarifasByInstitucionIdAndUbicacion(short institucionId, int ubicacion) {
        return this.saniTarifaDao.findAllByInstitucionAndUbicacion(
                this.institucionDao.findById(institucionId).orElse(null),
                this.saniubicacionDao.findById(ubicacion).orElse(null)
        );
    }
}
