package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Sanitarifa;
import com.fernando9825.alcaldiasvrestapi.models.entity.Saniubicacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISaniTarifaDao extends JpaRepository<Sanitarifa, Short> {

    List<Sanitarifa> findAllByInstitucion(Institucion institucion);

    List<Sanitarifa> findAllByInstitucionAndUbicacion(Institucion institucion, Saniubicacion saniubicacion);

}
