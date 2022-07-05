package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Divermovimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.Diverusuario;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface IDiverMovimientoService {

    List<Divermovimiento> findAllByUsuarioEmail(String usuarioEmail);

    List<Divermovimiento> findAllByUsuarioAndThirtyDays(Diverusuario usuario, Timestamp lastThirtyDays);

    @Transactional
    Divermovimiento save(Divermovimiento divermovimiento);
}
