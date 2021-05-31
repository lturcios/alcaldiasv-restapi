package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.ISaniUserDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Saniusuario;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ISaniUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaniUserImpl implements ISaniUserService {

    private final ISaniUserDao saniuserDao;

    @Autowired
    public SaniUserImpl(ISaniUserDao saniuserDao){
        this.saniuserDao = saniuserDao;
    }

    @Override
    public List<Saniusuario> findAll() {
        return (List<Saniusuario>) saniuserDao.findAll();
    }

    @Override
    public Saniusuario findById(String idusername) {
        return saniuserDao.findById(idusername).orElse(null);
    }

    @Override
    public Saniusuario save(Saniusuario usuario) {
        return saniuserDao.save(usuario);
    }

    @Override
    public void delete(String username) {
        saniuserDao.deleteById(username);
    }
}
