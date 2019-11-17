package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.InstitucionInterfaceService;
import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitucionImpl implements com.fernando9825.alcaldiasvrestapi.models.services.interfaces.InstitucionInterfaceService {


    private final InstitucionInterfaceService institucionDao;

    @Autowired
    public InstitucionImpl(InstitucionInterfaceService institucionDao) {
        this.institucionDao = institucionDao;
    }

    @Override
    public Institucion findById(short institucionId) {
        return this.institucionDao.findById(institucionId).orElse(null);
    }

}
