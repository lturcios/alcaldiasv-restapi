package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IContribuyenteDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.InstitucionDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Contribuyente;
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
    public Contribuyente findById(Long contribuyenteId) {
        return this.contribuyenteDao.findById(contribuyenteId).orElse(null);
    }

    @Override
    public List<Contribuyente> findByInstitucionId(Long institucionId) {
        return this.contribuyenteDao.findByInstitucion(
                this.institucionDao.findById(institucionId).orElse(null)
        );
    }

    @Override
    public Contribuyente save(Contribuyente contribuyente) {
        return this.contribuyenteDao.save(contribuyente);
    }

    @Override
    public void delete(Long contribuyenteId) {
        this.contribuyenteDao.deleteById(contribuyenteId);
    }
}
