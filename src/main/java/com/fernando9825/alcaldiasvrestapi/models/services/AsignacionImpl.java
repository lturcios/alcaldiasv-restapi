package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IAsignacionDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.IPuestoDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Asignacion;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IAsignacionService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.InstitucionInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignacionImpl implements IAsignacionService {

    // InstitucionService
    private final InstitucionInterfaceService institucionService;

    private final IAsignacionDao asignacionDao;

    private final IPuestoDao puestoDao;

    @Autowired
    public AsignacionImpl(IAsignacionDao asignacionDao, InstitucionInterfaceService institucionService, IPuestoDao puestoDao) {
        this.asignacionDao = asignacionDao;
        this.institucionService = institucionService;
        this.puestoDao = puestoDao;
    }

    @Override
    public List<Asignacion> findAll() {
        return this.asignacionDao.findAll();
    }

    @Override
    public Asignacion findByInstitucionIdAndPuestoId(short institucionId, int puestoId) {
        return this.asignacionDao.findByInstitucionAndPuesto(
                this.institucionService.findById(institucionId),
                this.puestoDao.findById(puestoId).orElse(null)
        );

    }

    @Override
    public List<Asignacion> findByInstitucionId(short institucionId) {
        return this.asignacionDao.findAllByInstitucion(
                this.institucionService.findById(institucionId)
        );
    }

    @Override
    public Asignacion findById(int asignacionId) {
        return this.asignacionDao.findById(asignacionId).orElse(null);
    }

    @Override
    public Asignacion save(Asignacion asignacion) {
        return this.asignacionDao.save(asignacion);
    }

    @Override
    public void delete(int asignacionId) {
        this.asignacionDao.deleteById(asignacionId);
    }
}
