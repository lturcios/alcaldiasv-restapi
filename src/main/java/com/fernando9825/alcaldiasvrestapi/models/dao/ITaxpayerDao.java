package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Taxpayer;
import org.springframework.data.repository.CrudRepository;

public interface ITaxpayerDao extends CrudRepository<Taxpayer, String> {
}
