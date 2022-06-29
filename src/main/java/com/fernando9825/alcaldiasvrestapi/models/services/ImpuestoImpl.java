package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IImpuestoDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.IPuestoDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.IRutaDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.IUserDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Impuesto;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IImpuestoService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.InstitucionInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpuestoImpl implements IImpuestoService {

    private final InstitucionInterfaceService institucionService;

    private final IImpuestoDao impuestoDao;

    private final IPuestoDao puestoDao;

    @Autowired
    public ImpuestoImpl(InstitucionInterfaceService institucionService,
                        IImpuestoDao impuestoDao,
                        IPuestoDao puestoDao,
                        IRutaDao rutaDao,
                        IUserDao userDao) {
        this.institucionService = institucionService;
        this.impuestoDao = impuestoDao;
        this.puestoDao = puestoDao;
    }

    @Override
    public List<Impuesto> findAll() {
        return this.impuestoDao.findAll();
    }

    @Override
    public Impuesto findByInstitucionIdAndPuestoId(short institucionId, int puestoId) {
        return this.impuestoDao.findByInstitucionAndPuesto(
                this.institucionService.findById(institucionId),
                this.puestoDao.findById(puestoId).orElse(null)
        );
    }

    @Override
    public List<Impuesto> findByInstitucionIdAndUsuarioEmail(short institucionId, String usuarioEmail) {
        return this.impuestoDao.findAllByInstitucionAndUsuario(
                institucionId, usuarioEmail
        );
    }

    @Override
    public List<Impuesto> findByInstitucionId(short institucionId) {
        return this.impuestoDao.findAllByInstitucion(
                this.institucionService.findById(institucionId)
        );
    }

    @Override
    public Impuesto findById(int impuestoId) {
        return this.impuestoDao.findById(impuestoId).orElse(null);
    }

    @Override
    public Impuesto save(Impuesto impuesto) {
        return this.impuestoDao.save(impuesto);
    }

    @Override
    public void delete(int impuestoId) {
        this.impuestoDao.deleteById(impuestoId);
    }
}
