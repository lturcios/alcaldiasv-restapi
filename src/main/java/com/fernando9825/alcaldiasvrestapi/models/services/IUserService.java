package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.entity.Usuario;

import java.util.List;

public interface IUserService {

    List<Usuario> findAll();

    Usuario findById(String username);

    Usuario save(Usuario usuario);

    void delete(String username);
}
