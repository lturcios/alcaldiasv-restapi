package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.TuriUser;

import java.util.List;

public interface ITuriUserService {

    List<TuriUser> findAll();

    TuriUser findById(String username);

    TuriUser save(TuriUser user);

    void delete(String username);

}
