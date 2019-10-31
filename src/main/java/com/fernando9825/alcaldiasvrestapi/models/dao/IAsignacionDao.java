package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Asignacion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Puesto;
import com.fernando9825.alcaldiasvrestapi.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAsignacionDao extends JpaRepository<Asignacion, Long> {

    List<Asignacion> findByInstitucionAndPuesto(Institucion institucion, Puesto puesto);
}
