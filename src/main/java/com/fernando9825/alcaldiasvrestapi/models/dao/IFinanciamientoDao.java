package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Financiamiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFinanciamientoDao extends JpaRepository<Financiamiento, Integer> {

    Financiamiento findByInstitucionAndPuesto(Institucion institucion, Puesto puesto);

    Financiamiento findByContribuyenteId(int contgribuyenteId);

    List<Financiamiento> findAllByInstitucion(Institucion institucion);

    @Query("select f from Financiamiento AS f WHERE f.institucion.id = :institucion " +
            "AND f.puesto.id IN (SELECT p.id FROM Ruta AS r LEFT JOIN r.puestos AS p WHERE r.usuario.email = :usuario)")
    List<Financiamiento> findAllByInstitucionAndUsuario(short institucion, String usuario);

}
