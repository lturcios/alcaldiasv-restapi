package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Impuesto;
import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IImpuestoDao extends JpaRepository<Impuesto, Integer> {

    Impuesto findByInstitucionAndPuesto(Institucion institucion, Puesto puesto);

    List<Impuesto> findAllByInstitucion(Institucion institucion);

    @Query("select i from Impuesto AS i WHERE i.institucion.id = :institucion " +
            "AND i.puesto.id IN (SELECT p.id FROM Ruta AS r LEFT JOIN r.puestos AS p WHERE r.usuario.email = :usuario)")
    List<Impuesto> findAllByInstitucionAndUsuario(short institucion, String usuario);

}
