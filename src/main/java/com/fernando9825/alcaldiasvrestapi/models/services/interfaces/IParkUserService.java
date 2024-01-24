package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Parkusuario;

import java.util.List;

public interface IParkUserService {

    List<Parkusuario> findAll();

    Parkusuario findById(String idusername);

    Parkusuario save(Parkusuario parkusuario);

    void delete(String idusername);

}
