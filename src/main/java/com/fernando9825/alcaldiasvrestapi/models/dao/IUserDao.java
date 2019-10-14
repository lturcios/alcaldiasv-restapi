package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<Usuario, String> {
}
