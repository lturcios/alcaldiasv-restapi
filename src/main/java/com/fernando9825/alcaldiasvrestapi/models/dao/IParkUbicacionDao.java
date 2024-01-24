package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Parkubicacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IParkUbicacionDao extends JpaRepository<Parkubicacion, Integer> {

    List<Parkubicacion> findByInstitucionId(short institucionId);
}
