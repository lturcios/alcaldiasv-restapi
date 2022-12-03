package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.DiverMovimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface IDiverMovimientoService {

    List<DiverMovimiento> findAllByUsuarioEmail(String usuarioEmail);

    List<DiverMovimiento> findAllByUsuarioAndFechahorapago(Usuario usuario, Timestamp fechahorapago);

    @Transactional
    DiverMovimiento save(DiverMovimiento diverMovimiento);
}
