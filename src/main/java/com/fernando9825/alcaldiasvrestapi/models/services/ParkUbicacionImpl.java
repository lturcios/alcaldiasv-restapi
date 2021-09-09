package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IParkUbicacionDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Parkubicacion;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IParkUbicacionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkUbicacionImpl implements IParkUbicacionService {

    private final IParkUbicacionDao parkUbicacionDao;

    public ParkUbicacionImpl(IParkUbicacionDao parkUbicacionDao) {
        this.parkUbicacionDao = parkUbicacionDao;
    }

    @Override
    public List<Parkubicacion> findAll() { return this.parkUbicacionDao.findAll(); }

    @Override
    public List<Parkubicacion> findByInstitucionId(short institucionId) {
        return this.parkUbicacionDao.findByInstitucionId(institucionId);
    }

    @Override
    public Parkubicacion findById(int parkubicacionId) {
        return this.parkUbicacionDao.findById(parkubicacionId).orElse(null);
    }

    @Override
    public Parkubicacion save(Parkubicacion parkubicacion) { return this.parkUbicacionDao.save(parkubicacion); }


    @Override
    public void delete(int parkubicacionId) { this.parkUbicacionDao.deleteById(parkubicacionId);}
}
