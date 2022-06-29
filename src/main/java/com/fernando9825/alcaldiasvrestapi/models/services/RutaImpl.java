package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IRutaDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.InstitucionDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Ruta;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IRutaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutaImpl implements IRutaService {

    private final IRutaDao rutaDao;
    private final InstitucionDao institucionDao;

    public RutaImpl(IRutaDao rutaDao, InstitucionDao institucionDao) {
        this.rutaDao = rutaDao;
        this.institucionDao = institucionDao;
    }

    @Override
    public List<Ruta> findAll() {
        return rutaDao.findAll();
    }

    @Override
    public Ruta findById(short rutaId) {
        return this.rutaDao.findById(rutaId);
    }


    @Override
    public List<Ruta> findByInstitucionId(short institucionId) {
        return this.rutaDao.findAllByInstitucion(this.institucionDao.findById(institucionId).orElse(null));
    }

    @Override
    public List<Ruta> findAllByInstitucionIdAndUsuarioEmail(short institucionId, String usuarioEmail) {
        return this.rutaDao.findAllByInstitucionIdAndUsuarioEmail(institucionId, usuarioEmail);
    }

    @Override
    public Ruta save(Ruta ruta) {
        return this.rutaDao.save(ruta);
    }

    @Override
    public void delete(short rutaId) {
        this.rutaDao.deleteById(rutaId);
    }
}
