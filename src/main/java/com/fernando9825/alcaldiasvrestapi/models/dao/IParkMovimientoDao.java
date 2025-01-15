package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Parkmovimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface IParkMovimientoDao extends JpaRepository<Parkmovimiento, String> {

    List<Parkmovimiento> findAllByUsuarioEntrada(String parkusuario);

    Parkmovimiento findByPagoId(String pagoId);

    @Query(value = "select pm from Parkmovimiento pm where pm.usuarioSalida = ?1 and pm.fechaHorapago >= ?2")
    Optional<List<Parkmovimiento>> findAllByUsuarioAndFechaHorapago(String parkusuario, Timestamp fechaHorapago);

    @Query(value = "select pm from Parkmovimiento pm where pm.usuarioEntrada = ?1 and pm.fechaHoraentra >= ?2")
    Optional<List<Parkmovimiento>> findAllByUsuarioAndFechaHoraentra(String parkusuario, Timestamp fechaHoraentra);

    @Query(value = "select pm from Parkmovimiento pm where pm.ubicacion.id = ?1 and pm.fechaHoraentra >= ?2")
    Optional<List<Parkmovimiento>> findAllByUbicacion(Integer ubicacionId, Timestamp fechaHoraentra);

    @Query(value = "select pm from Parkmovimiento pm where (pm.ubicacion.id = ?1 and pm.usuarioSalida is null and pm.fechaHoraentra >= ?3 and pm.fechaHorasale is null) " +
            "or (pm.ubicacion.id = ?1 and pm.usuarioSalida = ?2 and pm.fechaHoraentra >= ?3)")
    Optional<List<Parkmovimiento>> findAllByUbicacionAndUsuarioSalida(Integer ubicacionId, String usuario, Timestamp fechaHoraentra);

    @Query(value = "select pm from Parkmovimiento pm where pm.ubicacion.id = ?1 and pm.fechaHorasale is null and pm.observaciones is null")
    Optional<List<Parkmovimiento>> findAllByUbicacionAndFechaHorasaleIsEmpty(Integer ubicacionId);

    @Query(value = "select pm from Parkmovimiento pm where pm.ubicacion.id = ?1 and pm.fechaHorasale is null")
    Optional<List<Parkmovimiento>> findAllByUbicacionAndFechaHorasaleIsEmptyE(Integer ubicacionId);

    @Modifying
    @Query(value = "update Parkmovimiento pm set pm.observaciones = ?2 where pm.ubicacion.id = ?1 and pm.fechaHorasale is null and pm.observaciones is null")
    void updateAllByUbicacionAndFechaHorasaleIsEmpty(Integer ubicacionId, String observaciones);

}
