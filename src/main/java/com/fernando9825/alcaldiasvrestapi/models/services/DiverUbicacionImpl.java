package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IDiverUbicacionDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Diverubicacion;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IDiverUbicacionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiverUbicacionImpl implements IDiverUbicacionService {

    private final IDiverUbicacionDao ubicacionDao;

    public DiverUbicacionImpl(IDiverUbicacionDao ubicacionDao) {
        this.ubicacionDao = ubicacionDao;
    }

    @Override
    public List<Diverubicacion> findAll() {
        return this.ubicacionDao.findAll();
    }

    @Override
    public List<Diverubicacion> findByInstitucionId(short institucionId) {
        return this.ubicacionDao.findByInstitucionId(institucionId);
    }

    @Override
    public Diverubicacion findById(int diverubicacionId) {
        return this.ubicacionDao.findById(diverubicacionId).orElse(null);
    }

    @Override
    public Diverubicacion save(Diverubicacion diverubicacion) {
        return this.ubicacionDao.save(diverubicacion);
    }

    @Override
    public void delete(int diverubicacionId) {
        this.ubicacionDao.deleteById(diverubicacionId);
    }
}
