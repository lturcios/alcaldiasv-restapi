package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Contribuyente;
import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IContribuyenteDao extends JpaRepository<Contribuyente, Integer> {

    // lista de contribuyentes por alcaldia (institucion)


    List<Contribuyente> findByInstitucion(Institucion institucion);
}
