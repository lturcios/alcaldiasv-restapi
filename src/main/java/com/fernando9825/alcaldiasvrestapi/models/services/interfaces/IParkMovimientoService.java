package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Parkmovimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.Parkusuario;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface IParkMovimientoService {

    List<Parkmovimiento> findAllByUsuarioEmail(String usuarioEmail);

    List<Parkmovimiento> findAllByUsuarioAndFechaHorapago(Parkusuario parkusuario, Timestamp fechaHorapago);

    List<Parkmovimiento> findAllByUsuarioAndFechaHoraentra(Parkusuario parkusuario, Timestamp fechaHoraentra);

    List<Parkmovimiento> findAllByUbicacionId(Integer ubicacionId, Timestamp fechaHoraentra);

    List<Parkmovimiento> findAllByUbicacionAndFechaHorasaleIsEmpty(Integer ubicacionId);

    List<Parkmovimiento> findAllByUbicacionAndFechaHorasaleIsEmptyE(Integer ubicacionId);

    @Transactional
    void updateAllByUbicacionAndFechaHorasaleIsEmpty(Integer ubicacionId, String observaciones);

    Parkmovimiento findById(String pagoId);

    @Transactional
    Parkmovimiento save(Parkmovimiento parkmovimiento);

}
