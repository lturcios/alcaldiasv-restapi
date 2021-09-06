package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Parkmovimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.Parkusuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface IParkMovimientoDao extends JpaRepository<Parkmovimiento, String> {

    List<Parkmovimiento> findAllByUsuario(Parkusuario parkusuario);

    Parkmovimiento findByPagoId(String pagoId);

    @Query(value = "select pm from Parkmovimiento pm where pm.usuario = ?1 and pm.fechaHorapago >= ?2")
    Optional<List<Parkmovimiento>> findAllByUsuarioAndFechaHorapago(Parkusuario parkusuario, Timestamp fechaHorapago);

}
