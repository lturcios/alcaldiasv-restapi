package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IPuestoDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.IRutaDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.IServicioDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.IUserDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Servicio;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IServicioService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.InstitucionInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioImpl implements IServicioService {

    private final InstitucionInterfaceService institucionService;
    private final IServicioDao servicioDao;
    private final IPuestoDao puestoDao;
    private final IRutaDao rutaDao;
    private final IUserDao userDao;

    @Autowired
    public ServicioImpl(InstitucionInterfaceService institucionService,
                        IServicioDao servicioDao,
                        IPuestoDao puestoDao,
                        IRutaDao rutaDao,
                        IUserDao userDao) {
        this.institucionService = institucionService;
        this.servicioDao = servicioDao;
        this.puestoDao = puestoDao;
        this.rutaDao = rutaDao;
        this.userDao = userDao;
    }

    @Override
    public List<Servicio> findAll() {
        return this.servicioDao.findAll();
    }

    @Override
    public Servicio findByInstitucionIdAndPuestoId(short institucionId, int puestoId) {
        return this.servicioDao.findByInstitucionAndPuesto(
                this.institucionService.findById(institucionId),
                this.puestoDao.findById(puestoId).orElse(null)
        );
    }

    @Override
    public List<Servicio> findByInstitucionIdAndUsuarioEmail(short institucionId, String usuarioEmail) {
        return this.servicioDao.findAllByInstitucionAndUsuario(
                institucionId, usuarioEmail
        );
    }

    @Override
    public List<Servicio> findByInstitucionId(short institucionId) {
        return this.servicioDao.findAllByInstitucion(
                this.institucionService.findById(institucionId)
        );
    }

    @Override
    public Servicio findById(int servicioId) {
        return this.servicioDao.findById(servicioId).orElse(null);
    }

    @Override
    public Servicio findByContribuyenteId(int contribuyenteId) {
        return this.servicioDao.findByContribuyenteId(contribuyenteId);
    }

    @Override
    public Servicio save(Servicio servicio) {
        return this.servicioDao.save(servicio);
    }

    @Override
    public void delete(int servicioId) {
        this.servicioDao.deleteById(servicioId);
    }
}
