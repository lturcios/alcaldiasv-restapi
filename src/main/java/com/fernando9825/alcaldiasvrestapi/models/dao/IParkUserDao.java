package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Parkusuario;
import org.springframework.data.repository.CrudRepository;

public interface IParkUserDao extends CrudRepository<Parkusuario, String> {
}
