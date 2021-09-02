package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IParkTarifaDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.IParkUbicacionDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Parktarifa;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IParkTarifaService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.InstitucionInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkTarifaImpl implements IParkTarifaService {

    private final IParkTarifaDao parkTarifaDao;
    private final InstitucionInterfaceService institucionDao;
    private final IParkUbicacionDao parkUbicacionDao;

    @Autowired
    public ParkTarifaImpl(
            IParkTarifaDao parkTarifaDao,
            InstitucionInterfaceService institucionDao,
            IParkUbicacionDao parkUbicacionDao
    ) {
        this.parkTarifaDao = parkTarifaDao;
        this.institucionDao = institucionDao;
        this.parkUbicacionDao = parkUbicacionDao;
    }


    @Override
    public List<Parktarifa> getAllParkTarifasByInstitucionId(short institucionId) {
        return this.parkTarifaDao.findAllByInstitucion(
                this.institucionDao.findById(institucionId)
        );
    }

    @Override
    public List<Parktarifa> getAllParkTarifasByInstitucionIdAndUbicacion(short institucionId, int ubicacion) {
        return this.parkTarifaDao.findAllByInstitucionAndUbicacion(
                this.institucionDao.findById(institucionId),
                this.parkUbicacionDao.findById((short) ubicacion)
        );
    }
}
