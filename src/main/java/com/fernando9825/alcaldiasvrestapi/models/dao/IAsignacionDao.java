package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Asignacion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static org.hibernate.FetchMode.JOIN;

public interface IAsignacionDao extends JpaRepository<Asignacion, Integer> {

    Asignacion findByInstitucionAndPuesto(Institucion institucion, Puesto puesto);
//    Asignacion findAsignacionByIns

    public List<Asignacion> findAllByInstitucion(Institucion institucion);
}
