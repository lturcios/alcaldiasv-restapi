package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IContribuyenteDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.InstitucionDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Contribuyente;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IContribuyenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContribuyenteImpl implements IContribuyenteService {

    private final IContribuyenteDao contribuyenteDao;
    private final InstitucionDao institucionDao;

    @Autowired
    public ContribuyenteImpl(IContribuyenteDao contribuyenteDao, InstitucionDao institucionDao) {
        this.contribuyenteDao = contribuyenteDao;
        this.institucionDao = institucionDao;
    }

    @Override
    public List<Contribuyente> findAll() {
        return this.contribuyenteDao.findAll();
    }

    @Override
    public Contribuyente findById(int contribuyenteId) {
        return this.contribuyenteDao.findById(contribuyenteId).orElse(null);
    }

    @Override
    public List<Contribuyente> findByInstitucionId(short institucionId) {
        return this.contribuyenteDao.findByInstitucion(
                this.institucionDao.findById(institucionId).orElse(null)
        );
    }

    @Override
    public List<Contribuyente> findByInstitucionIdAndUsuarioEmail(short institucionId, String usuarioEmail) {
        return this.contribuyenteDao.findByInstitucionIdAndUsuarioEmail(
                institucionId, usuarioEmail
        );
    }

    @Override
    public Contribuyente save(Contribuyente contribuyente) {
        return this.contribuyenteDao.save(contribuyente);
    }

    @Override
    public void delete(int contribuyenteId) {
        this.contribuyenteDao.deleteById(contribuyenteId);
    }
}
