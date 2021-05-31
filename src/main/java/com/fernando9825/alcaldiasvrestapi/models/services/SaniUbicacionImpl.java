package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.ISaniUbicacionDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Saniubicacion;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ISaniUbicacionService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.InstitucionInterfaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaniUbicacionImpl implements ISaniUbicacionService {

    private final InstitucionInterfaceService institucionService;

    private final ISaniUbicacionDao ubicacionDao;

    public SaniUbicacionImpl(ISaniUbicacionDao ubicacionDao, InstitucionInterfaceService institucionService){
        this.ubicacionDao = ubicacionDao;
        this.institucionService = institucionService;
    }

    @Override
    public List<Saniubicacion> findAll() {
        return this.ubicacionDao.findAll();
    }

    @Override
    public List<Saniubicacion> findByInstitucionId(short institucionId) {
        return this.ubicacionDao.findByInstitucionId(
                this.institucionService.findById(institucionId)
        );
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
