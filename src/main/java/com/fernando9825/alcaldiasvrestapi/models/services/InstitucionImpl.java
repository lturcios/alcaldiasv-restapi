package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.InstitucionInterfaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitucionImpl implements InstitucionInterfaceService {


    @Override
    public List<Institucion> findAll() {
        return null;
    }

    @Override
    public Institucion findById(Long institucionId) {
        return null;
    }

    @Override
    public Institucion save(Institucion institucion) {
        return null;
    }

    @Override
    public void delete(Long institucionId) {

    }
}
