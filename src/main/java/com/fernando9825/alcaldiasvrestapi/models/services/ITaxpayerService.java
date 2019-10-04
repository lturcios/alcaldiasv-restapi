package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.entity.Taxpayer;

import java.util.List;

public interface ITaxpayerService {

    List<Taxpayer> findAll();

    Taxpayer findById(String DUI);

    Taxpayer save(Taxpayer taxpayer);

    void delete(String DUI);
}
