package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IRutaDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.IUserDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.InstitucionDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Ruta;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IRutaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutaImpl implements IRutaService {

    private final IRutaDao rutaDao;
    private final InstitucionDao institucionDao;
    private final IUserDao userDao;

    public RutaImpl(IRutaDao rutaDao, InstitucionDao institucionDao, IUserDao userDao) {
        this.rutaDao = rutaDao;
        this.institucionDao = institucionDao;
        this.userDao = userDao;
    }

    @Override
    public List<Ruta> findAll() {
        return rutaDao.findAll();
    }

    @Override
    public Ruta findById(Long rutaId) {
        return this.rutaDao.findById(rutaId).orElse(null);
    }


    @Override
    public List<Ruta> findByInstitucionId(Long institucionId) {
        return this.rutaDao.findAllByInstitucion(this.institucionDao.findById(institucionId).orElse(null));
    }

    @Override
    public Ruta save(Ruta ruta) {
        return this.rutaDao.save(ruta);
    }

    @Override
    public void delete(Long rutaId) {
        this.rutaDao.deleteById(rutaId);
    }
}
