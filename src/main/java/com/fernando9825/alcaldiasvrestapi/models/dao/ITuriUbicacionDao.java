package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.TuriUbicacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITuriUbicacionDao extends JpaRepository<TuriUbicacion, Integer> {
    List<TuriUbicacion> findByInstitucionId(short institucion);
}
