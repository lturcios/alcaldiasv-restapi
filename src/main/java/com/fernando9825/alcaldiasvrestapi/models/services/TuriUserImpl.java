package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.ITuriUserDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.TuriUser;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ITuriUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuriUserImpl implements ITuriUserService {

    private final ITuriUserDao turiUserDao;

    @Autowired
    public TuriUserImpl(ITuriUserDao turiUserDao) {
        this.turiUserDao = turiUserDao;
    }

    @Override
    public List<TuriUser> findAll() {
        return  (List<TuriUser>) turiUserDao.findAll();
    }

    @Override
    public TuriUser findById(String username) {
        return  this.turiUserDao.findById(username).orElse(null);
    }

    @Override
    public TuriUser save(TuriUser user) {
        return this.turiUserDao.save(user);       }

    @Override
    public void delete(String username) {
        this.turiUserDao.deleteById(username);
    }
}


