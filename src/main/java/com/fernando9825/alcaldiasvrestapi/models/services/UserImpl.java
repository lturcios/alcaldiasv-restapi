package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IUserDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Usuario;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements IUserService {

    private final IUserDao userDao;

    @Autowired
    public UserImpl(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) userDao.findAll();
    }

    @Override
    public Usuario findById(String username) {
        return userDao.findById(username).orElse(null);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return userDao.save(usuario);
    }

    @Override
    public void delete(String username) {
        userDao.deleteById(username);
    }
}
