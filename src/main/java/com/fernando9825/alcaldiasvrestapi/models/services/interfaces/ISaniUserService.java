package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Saniusuario;

import java.util.List;

public interface ISaniUserService {

    List<Saniusuario> findAll();

    Saniusuario findById(String idusername);

    Saniusuario save(Saniusuario usuario);

    void delete(String username);
}
