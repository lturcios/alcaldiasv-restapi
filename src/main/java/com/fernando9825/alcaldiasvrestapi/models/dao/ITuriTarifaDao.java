package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import com.fernando9825.alcaldiasvrestapi.models.entity.TuriTarifa;
import com.fernando9825.alcaldiasvrestapi.models.entity.TuriUbicacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITuriTarifaDao extends JpaRepository<TuriTarifa, Short> {
    List<TuriTarifa> findAllByInstitucionAndUbicacion(Institucion institucion, TuriUbicacion ubicacion);
}
