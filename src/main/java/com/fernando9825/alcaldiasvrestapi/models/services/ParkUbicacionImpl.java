package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IParkUbicacionDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Parkubicacion;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IParkUbicacionService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.InstitucionInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkUbicacionImpl implements IParkUbicacionService {

    private final InstitucionInterfaceService institucionService;
    private final IParkUbicacionDao parkUbicacionDao;

    @Autowired
    public ParkUbicacionImpl(InstitucionInterfaceService institucionService, IParkUbicacionDao parkUbicacionDao) {
        this.institucionService = institucionService;
        this.parkUbicacionDao = parkUbicacionDao;
    }

    @Override
    public List<Parkubicacion> findAll() { return this.parkUbicacionDao.findAll(); }

    @Override
    public List<Parkubicacion> findByInstitucionId(short institucionId) {
        return this.parkUbicacionDao.findByInstitucionId(
                this.institucionService.findById(institucionId)
        );
    }

    @Override
    public Parkubicacion findById(short parkubicacionId) {
        return this.parkUbicacionDao.findById(parkubicacionId).orElse(null);
    }

    @Override
    public Parkubicacion save(Parkubicacion parkubicacion) { return this.parkUbicacionDao.save(parkubicacion); }

    @Override
    public void delete(short parkubicacionId) { this.parkUbicacionDao.deleteById(parkubicacionId);}
}
