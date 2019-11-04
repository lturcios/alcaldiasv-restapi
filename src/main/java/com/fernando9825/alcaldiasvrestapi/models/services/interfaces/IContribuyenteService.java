package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Contribuyente;

import java.util.List;

public interface IContribuyenteService {

    List<Contribuyente> findAll();

    Contribuyente findById(Long contribuyenteId);

    List<Contribuyente> findByInstitucionId(Long institucionId);

    Contribuyente save(Contribuyente contribuyente);

    void delete(Long contribuyenteId);

}
