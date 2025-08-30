package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.dto.TuriMovimientoDTO;
import com.fernando9825.alcaldiasvrestapi.models.entity.TuriMovimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.TuriUbicacion;
import com.fernando9825.alcaldiasvrestapi.models.entity.TuriUser;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface ITuriMovimientoService {

    List<TuriMovimiento> findAllByTuriUser (String usuarioEmail);

    List<TuriMovimiento> findAllByUsuarioAndFechaHorapago(TuriUser turiUser, Timestamp fechahorapago);

    List<TuriMovimiento> findAllByUbicacion(TuriUbicacion ubicacionId);

    @Transactional
    TuriMovimiento crearMovimiento(TuriMovimientoDTO turiMovimiento);
}
