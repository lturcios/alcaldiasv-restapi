package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Diverusuario;
import org.springframework.data.repository.CrudRepository;

public interface IDiverUserDao extends CrudRepository<Diverusuario, String> {
}
