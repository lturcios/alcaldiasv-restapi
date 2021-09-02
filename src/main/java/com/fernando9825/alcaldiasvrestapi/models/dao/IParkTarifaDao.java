package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Parktarifa;
import com.fernando9825.alcaldiasvrestapi.models.entity.Parkubicacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IParkTarifaDao extends JpaRepository<Parktarifa, Short> {

    List<Parktarifa> findAllByInstitucion(Institucion institucion);

    List<Parktarifa> findAllByInstitucionAndUbicacion(Institucion institucion, Optional<Parkubicacion> parkubicacion);

}
