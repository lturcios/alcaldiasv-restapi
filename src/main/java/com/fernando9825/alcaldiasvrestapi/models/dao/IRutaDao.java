package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Ruta;
import com.fernando9825.alcaldiasvrestapi.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRutaDao extends JpaRepository<Ruta, Long> {

    List<Ruta> findByInstitucionAndUsuario(Institucion institucion, Usuario usuario);

}
