package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.ITuriUbicacionDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.TuriUbicacion;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ITuriUbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuriUbicacionImpl implements ITuriUbicacionService {

    private final ITuriUbicacionDao turiUbicacionDao;

    @Autowired
    public TuriUbicacionImpl(ITuriUbicacionDao turiUbicacionDao) {
        this.turiUbicacionDao = turiUbicacionDao;
    }


    @Override
    public List<TuriUbicacion> findAll() {
        return this.turiUbicacionDao.findAll();
    }

    @Override
    public List<TuriUbicacion> findByInstitucionId(short institucionId) {
        return this.turiUbicacionDao.findByInstitucionId(institucionId);
    }

    @Override
    public TuriUbicacion findById(int turiubicacionId) {
        return this.turiUbicacionDao.findById(turiubicacionId).orElse(null);
    }

    @Override
    public TuriUbicacion save(TuriUbicacion turiUbicacion) {
        return this.turiUbicacionDao.save(turiUbicacion);
    }

    @Override
    public void delete(int turiubicacionId) {
        this.turiUbicacionDao.deleteById(turiubicacionId);
    }
}
