package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Asignacion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAsignacionDao extends JpaRepository<Asignacion, Long> {

    Asignacion findByInstitucionAndPuesto(Institucion institucion, Puesto puesto);
//    Asignacion findAsignacionByIns
    @Query("SELECT u FROM Asignacion u WHERE u.institucion = ?1")
    List<Asignacion> findByInstitucion(Institucion institucion);
}
