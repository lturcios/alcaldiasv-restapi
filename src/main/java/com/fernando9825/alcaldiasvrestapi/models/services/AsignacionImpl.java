package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IAsignacionDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.IPuestoDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.InstitucionDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Asignacion;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IAsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignacionImpl implements IAsignacionService {


    private final IAsignacionDao asignacionDao;
    private final InstitucionDao institucionDao;
    private final IPuestoDao puestoDao;

    @Autowired
    public AsignacionImpl(IAsignacionDao asignacionDao, InstitucionDao institucionDao, IPuestoDao puestoDao) {
        this.asignacionDao = asignacionDao;
        this.institucionDao = institucionDao;
        this.puestoDao = puestoDao;
    }

    @Override
    public List<Asignacion> findAll() {
        return this.asignacionDao.findAll();
    }

    @Override
    public Asignacion findByInstitucionIdAndPuestoId(Long institucionId, Long puestoId) {
        return this.asignacionDao.findByInstitucionAndPuesto(
                this.institucionDao.findById(institucionId).orElse(null),
                this.puestoDao.findById(puestoId).orElse(null)
        );

    }

    @Override
    public List<Asignacion> findByInstitucionId(Long institucionId) {
        return this.asignacionDao.findAllByInstitucion(
                this.institucionDao.findById(institucionId).orElse(null)
        );
    }

    @Override
    public Asignacion findById(Long asignacionId) {
        return this.asignacionDao.findById(asignacionId).orElse(null);
    }

    @Override
    public Asignacion save(Asignacion asignacion) {
        return this.asignacionDao.save(asignacion);
    }

    @Override
    public void delete(Long asignacionId) {
        this.asignacionDao.deleteById(asignacionId);
    }
}
