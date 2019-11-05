package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITarifaDao extends JpaRepository<Tarifa, Long> {

    List<Tarifa> findAllByInstitucion(Institucion institucion);
}
