package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Diverubicacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDiverUbicacionDao extends JpaRepository<Diverubicacion, Integer> {

    List<Diverubicacion> findByInstitucionId(short institucion);

}
