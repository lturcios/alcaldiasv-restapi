package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.ITarifaDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.InstitucionInterfaceService;
import com.fernando9825.alcaldiasvrestapi.models.entity.Tarifa;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ITarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarifaImpl implements ITarifaService {

    private final ITarifaDao tarifaDao;
    private final InstitucionInterfaceService institucionDao;

    @Autowired
    public TarifaImpl(ITarifaDao tarifaDao, InstitucionInterfaceService institucionDao) {
        this.tarifaDao = tarifaDao;
        this.institucionDao = institucionDao;
    }

    @Override
    public List<Tarifa> getAllTarifasByInstitucion(short institucionId) {
        return this.tarifaDao.findAllByInstitucion(
                this.institucionDao.findById(institucionId).orElse(null)
        );
    }
}
