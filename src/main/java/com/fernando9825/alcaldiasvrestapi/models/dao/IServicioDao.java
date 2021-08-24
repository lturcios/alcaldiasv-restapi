package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Puesto;
import com.fernando9825.alcaldiasvrestapi.models.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IServicioDao extends JpaRepository<Servicio, Integer> {

    Servicio findByInstitucionAndPuesto(Institucion institucion, Puesto puesto);

    List<Servicio> findAllByInstitucion(Institucion institucion);

    @Query("select s from Servicio AS s WHERE s.institucion.id = :institucion " +
            "AND s.puesto.id IN (SELECT p.id FROM Ruta AS r LEFT JOIN r.puestos AS p WHERE r.usuario.email = :usuario)")
    List<Servicio> findAllByInstitucionAndUsuario(short institucion, String usuario);
}
