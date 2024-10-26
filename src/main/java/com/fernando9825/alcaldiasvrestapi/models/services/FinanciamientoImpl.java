package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IFinanciamientoDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.IPuestoDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.IRutaDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.IUserDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Financiamiento;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IFinanciamientoService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.InstitucionInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanciamientoImpl implements IFinanciamientoService {

    private final InstitucionInterfaceService institucionService;
    private final IFinanciamientoDao financiamientoDao;
    private final IPuestoDao puestoDao;
    private final IRutaDao rutaDao;
    private final IUserDao userDao;

    @Autowired
    public FinanciamientoImpl(InstitucionInterfaceService institucionService,
                              IFinanciamientoDao financiamientoDao,
                              IPuestoDao puestoDao,
                              IRutaDao rutaDao,
                              IUserDao userDao) {
        this.institucionService = institucionService;
        this.financiamientoDao = financiamientoDao;
        this.puestoDao = puestoDao;
        this.rutaDao = rutaDao;
        this.userDao = userDao;
    }

    @Override
    public List<Financiamiento> findAll() {
        return this.financiamientoDao.findAll();
    }

    @Override
    public Financiamiento findByInstitucionIdAndPuestoId(short institucionId, int puestoId) {
        return this.financiamientoDao.findByInstitucionAndPuesto(
                this.institucionService.findById(institucionId),
                this.puestoDao.findById(puestoId).orElse(null)
        );
    }

    @Override
    public List<Financiamiento> findByInstitucionId(short institucionId) {
        return this.financiamientoDao.findAllByInstitucion(institucionId);
    }

    @Override
    public List<Financiamiento> findByInstitucionIdAndUsuarioEmail(short institucionId, String usuarioEmail) {
        return this.financiamientoDao.findAllByInstitucionAndUsuario(institucionId, usuarioEmail);
    }

    @Override
    public Financiamiento findById(int financiamientoId) {
        return this.financiamientoDao.findById(financiamientoId).orElse(null);
    }

    @Override
    public Financiamiento findByContribuyenteId(int contribuyenteId) {
        return this.financiamientoDao.findByContribuyenteId(contribuyenteId);
    }

    @Override
    public Financiamiento save(Financiamiento financiamiento) {
        return this.financiamientoDao.save(financiamiento);
    }

    @Override
    public void delete(int financiamientoId) {
        this.financiamientoDao.deleteById(financiamientoId);
    }
}
