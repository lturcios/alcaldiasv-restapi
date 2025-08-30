package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.TuriMovimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.TuriUbicacion;
import com.fernando9825.alcaldiasvrestapi.models.entity.TuriUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface ITuriMovimientoDao extends JpaRepository<TuriMovimiento, String> {

    List<TuriMovimiento> findAllByUsuario(TuriUser usuario);

    List<TuriMovimiento> findAllByUbicacion(TuriUbicacion ubicacion);

    @Query(value = "select t from TuriMovimiento t where t.usuario = ?1 and t.fechaHorapago >= ?2")
    Optional<List<TuriMovimiento>> findAllByUsuarioAndFechaHorapago(TuriUser usuario, Timestamp fechahorapago);
}
