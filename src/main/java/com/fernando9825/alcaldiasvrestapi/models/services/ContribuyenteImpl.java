package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IContribuyenteDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Contribuyente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContribuyenteImpl implements IContribuyenteService {

    private final IContribuyenteDao contribuyenteDao;

    @Autowired
    public ContribuyenteImpl(IContribuyenteDao contribuyenteDao) {
        this.contribuyenteDao = contribuyenteDao;
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
    public Contribuyente save(Contribuyente contribuyente) {
        return this.contribuyenteDao.save(contribuyente);
    }

    @Override
    public void delete(Long contribuyenteId) {
        this.contribuyenteDao.deleteById(contribuyenteId);
    }
}
