package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Diverusuario;

import java.util.List;

public interface IDiverUserService {

    List<Diverusuario> findAll();

    Diverusuario findById(String username);

    Diverusuario save(Diverusuario diverusuario);

    void delete(String username);
}
