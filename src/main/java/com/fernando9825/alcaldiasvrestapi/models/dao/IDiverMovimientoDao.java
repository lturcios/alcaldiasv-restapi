package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Divermovimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.Diverusuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface IDiverMovimientoDao extends JpaRepository<Divermovimiento, String> {

    List<Divermovimiento> findAllByUsuario(Diverusuario diverusuario);

    @Query(value = "select a from Divermovimiento a where a.usuario = ?1 and a.fechaHorapago >= ?2")
    Optional<List<Divermovimiento>> findAllByUsuarioAndThirtyDays(Diverusuario diverusuario, Timestamp lastThirtyDays);

}
