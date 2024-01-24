package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IParkUserDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Parkusuario;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IParkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkUserImpl implements IParkUserService {

    private final IParkUserDao parkUserDao;

    @Autowired
    public ParkUserImpl(IParkUserDao parkUserDao) {
        this.parkUserDao = parkUserDao;
    }


    @Override
    public List<Parkusuario> findAll() {
        return (List<Parkusuario>) this.parkUserDao.findAll();
    }

    @Override
    public Parkusuario findById(String idusername) {
        return this.parkUserDao.findById(idusername).orElse(null);
    }

    @Override
    public Parkusuario save(Parkusuario parkusuario) {
        return this.parkUserDao.save(parkusuario);
    }

    @Override
    public void delete(String idusername) {
        this.parkUserDao.deleteById(idusername);
    }
}
