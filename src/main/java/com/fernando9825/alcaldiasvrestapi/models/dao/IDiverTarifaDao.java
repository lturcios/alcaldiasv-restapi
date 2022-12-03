package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.DiverTarifa;
import com.fernando9825.alcaldiasvrestapi.models.entity.DiverUbicacion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDiverTarifaDao extends JpaRepository<DiverTarifa, Short> {

    List<DiverTarifa> findAllByInstitucion(Institucion institucion);

    List<DiverTarifa> findAllByInstitucionAndUbicacion(Institucion institucion, DiverUbicacion diverUbicacion);

}
