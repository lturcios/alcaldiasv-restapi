package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Movimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface IMovimientoService {

    List<Movimiento> findAllByUsuarioEmail(String usuarioEmail);

    List<Movimiento> findAllByUsuarioAndThirtyDays(Usuario usuario, Timestamp lastThirtyDays);

    @Transactional
    Movimiento save(Movimiento movimiento);
}
