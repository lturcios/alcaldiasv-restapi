package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMunicipioDao extends JpaRepository<Municipio, Integer> {
}
