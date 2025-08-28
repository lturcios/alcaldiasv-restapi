package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IDiverUserDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Diverusuario;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IDiverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiverUserImpl implements IDiverUserService {

    private final IDiverUserDao diverUserDao;

    @Autowired
    public DiverUserImpl(IDiverUserDao diverUserDao) {
        this.diverUserDao = diverUserDao;
    }

    @Override
    public List<Diverusuario> findAll() {
        return (List<Diverusuario>) diverUserDao.findAll();
    }

    @Override
    public Diverusuario findById(String idusername) {
        return this.diverUserDao.findById(idusername).orElse(null);
    }

    @Override
    public Diverusuario save(Diverusuario diverusuario) {
        return this.diverUserDao.save(diverusuario);
    }

    @Override
    public void delete(String idusername) {
        this.diverUserDao.deleteById(idusername);
    }
}
