package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.ITaxpayerDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Taxpayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxpayerImpl implements ITaxpayerService {

    private final ITaxpayerDao taxpayerDao;

    @Autowired
    public TaxpayerImpl(ITaxpayerDao taxpayerDao){
        this.taxpayerDao = taxpayerDao;
    }

    @Override
    public List<Taxpayer> findAll() {
        return (List<Taxpayer>) taxpayerDao.findAll();
    }

    @Override
    public Taxpayer findById(String DUI) {
        return taxpayerDao.findById(DUI).orElse(null);
    }

    @Override
    public Taxpayer save(Taxpayer taxpayer) {
        return taxpayerDao.save(taxpayer);
    }

    @Override
    public void delete(String DUI) {
        taxpayerDao.deleteById(DUI);
    }
}
