package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.TuriUser;
import org.springframework.data.repository.CrudRepository;

public interface ITuriUserDao extends CrudRepository<TuriUser, String> {
}
