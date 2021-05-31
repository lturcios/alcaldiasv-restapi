package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Contribuyente;
import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContribuyenteDao extends JpaRepository<Contribuyente, Integer> {

    // lista de contribuyentes por alcaldia (institucion)
    List<Contribuyente> findByInstitucion(Institucion institucion);

    @Query("select c from Contribuyente AS c WHERE c.id IN (select a.contribuyente from Asignacion AS a WHERE a.institucion.id = :institucionId " +
            "AND a.puesto.id IN (SELECT p.id FROM Ruta AS r LEFT JOIN r.puestos AS p WHERE r.usuario.email = :usuario)) AND c.institucion.id = :institucionId")
    List<Contribuyente> findByInstitucionIdAndUsuarioEmail(short institucionId, String usuario);

}
