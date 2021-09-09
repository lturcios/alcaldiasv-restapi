package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.ISaniUbicacionDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Saniubicacion;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ISaniUbicacionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaniUbicacionImpl implements ISaniUbicacionService {

    private final ISaniUbicacionDao ubicacionDao;

    public SaniUbicacionImpl(ISaniUbicacionDao ubicacionDao){
        this.ubicacionDao = ubicacionDao;
    }

    @Override
    public List<Saniubicacion> findAll() {
        return this.ubicacionDao.findAll();
    }

    @Override
    public List<Saniubicacion> findByInstitucionId(short institucionId) {
        return this.ubicacionDao.findByInstitucionId(institucionId);
    }

    @Override
    public Saniubicacion findById(int saniubicacionId) {
        return this.ubicacionDao.findById(saniubicacionId).orElse(null);
    }

    @Override
    public Saniubicacion save(Saniubicacion saniubicacion) {
        return this.ubicacionDao.save(saniubicacion);
    }

    @Override
    public void delete(int saniubicacionId) {
        this.ubicacionDao.deleteById(saniubicacionId);
    }
}
