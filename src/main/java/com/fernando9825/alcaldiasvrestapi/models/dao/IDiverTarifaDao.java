package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Divertarifa;
import com.fernando9825.alcaldiasvrestapi.models.entity.Diverubicacion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDiverTarifaDao extends JpaRepository<Divertarifa, Short> {

    List<Divertarifa> findAllByInstitucion(Institucion institucion);

    List<Divertarifa> findAllByInstitucionAndUbicacion(Institucion institucion, Diverubicacion diverubicacion);
}
