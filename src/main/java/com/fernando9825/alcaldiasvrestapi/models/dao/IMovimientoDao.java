package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Movimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface IMovimientoDao extends JpaRepository<Movimiento, String> {

    List<Movimiento> findAllByUsuario(Usuario usuario);

    @Query(value = "select a from Movimiento a where a.usuario = ?1 and a.fechaHorapago >= ?2")
    Optional<List<Movimiento>> findAllByUsuarioAndThirtyDays(Usuario usuario, Timestamp lastThirtyDays);
}
