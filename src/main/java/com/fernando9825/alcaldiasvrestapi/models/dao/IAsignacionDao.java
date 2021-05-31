package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Asignacion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAsignacionDao extends JpaRepository<Asignacion, Integer> {

    Asignacion findByInstitucionAndPuesto(Institucion institucion, Puesto puesto);

    List<Asignacion> findAllByInstitucion(Institucion institucion);

    @Query("select a from Asignacion AS a WHERE a.institucion.id = :institucion " +
            "AND a.puesto.id IN (SELECT p.id FROM Ruta AS r LEFT JOIN r.puestos AS p WHERE r.usuario.email = :usuario)")
    List<Asignacion> findAllByInstitucionAndUsuario(short institucion, String usuario);
}
