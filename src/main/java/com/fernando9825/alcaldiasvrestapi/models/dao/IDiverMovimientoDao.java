package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.DiverMovimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface IDiverMovimientoDao extends JpaRepository<DiverMovimiento, String> {

    List<DiverMovimiento> findAllByUsuario(Usuario usuario);
    @Query(value = "select a from DiverMovimiento a where a.usuario = ?1 and a.fechaHorapago >= ?2")
    Optional<List<DiverMovimiento>> findAllByUsuarioAndFechaHorapago(Usuario usuario, Timestamp fechahorapago);

}
