package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Saniusuario;
import org.springframework.data.repository.CrudRepository;

public interface ISaniUserDao extends CrudRepository<Saniusuario, String> {
}
