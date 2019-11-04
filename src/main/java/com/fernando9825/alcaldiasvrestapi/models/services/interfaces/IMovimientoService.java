package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Movimiento;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IMovimientoService {

    List<Movimiento> findAllByUsuarioEmail(String usuarioEmail);

    @Transactional
    Movimiento save(Movimiento movimiento);
}
