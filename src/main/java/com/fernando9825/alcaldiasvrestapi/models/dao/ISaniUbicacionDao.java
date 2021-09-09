package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Saniubicacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISaniUbicacionDao extends JpaRepository<Saniubicacion, Integer> {

    List<Saniubicacion> findByInstitucionId(short institucion);

}
