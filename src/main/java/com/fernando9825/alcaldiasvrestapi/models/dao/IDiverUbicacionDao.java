package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.DiverUbicacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDiverUbicacionDao extends JpaRepository<DiverUbicacion, Integer> {

    List<DiverUbicacion> findByInstitucionId(short institucion);

}
