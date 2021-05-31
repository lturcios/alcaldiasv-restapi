package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Sanimovimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.Saniusuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface ISaniMovimientoDao extends JpaRepository<Sanimovimiento, String> {

    List<Sanimovimiento> findAllByUsuario(Saniusuario saniusuario);

    @Query(value = "select a from Sanimovimiento a where a.usuario = ?1 and a.fechaHorapago >= ?2")
    Optional<List<Sanimovimiento>> findAllByUsuarioAndThirtyDays(Saniusuario usuario, Timestamp lastThirtyDays);
}
