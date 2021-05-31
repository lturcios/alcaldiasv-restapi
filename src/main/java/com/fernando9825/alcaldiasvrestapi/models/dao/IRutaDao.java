package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Ruta;
import org.hibernate.mapping.Any;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRutaDao extends JpaRepository<Ruta, Any> {

    List<Ruta> findAllByInstitucion(Institucion institucion);

    List<Ruta> findAllByInstitucionIdAndUsuarioEmail(short institucionId, String usuario);

    Ruta findById(short rutaId);

    void deleteById(short id);

}
