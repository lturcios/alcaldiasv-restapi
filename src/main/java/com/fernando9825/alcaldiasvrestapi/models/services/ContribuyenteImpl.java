package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IContribuyenteDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Contribuyente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContribuyenteImpl implements IContribuyenteService {

    private final IContribuyenteDao taxpayerDao;

    @Autowired
    public ContribuyenteImpl(IContribuyenteDao taxpayerDao) {
        this.taxpayerDao = taxpayerDao;
    }

    @Override
    public List<Contribuyente> findAll() {
        return (List<Contribuyente>) taxpayerDao.findAll();
    }

    @Override
    public Contribuyente findById(String DUI) {
        return taxpayerDao.findById(DUI).orElse(null);
    }

    @Override
    public Contribuyente save(Contribuyente contribuyente) {
        return taxpayerDao.save(contribuyente);
    }

    @Override
    public void delete(String DUI) {
        taxpayerDao.deleteById(DUI);
    }
}
