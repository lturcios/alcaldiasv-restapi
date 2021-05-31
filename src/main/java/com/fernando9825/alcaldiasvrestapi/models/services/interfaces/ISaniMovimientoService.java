package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.Sanimovimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.Saniusuario;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface ISaniMovimientoService {

    List<Sanimovimiento> findAllByUsuarioEmail(String usuarioEmail);

    List<Sanimovimiento> findAllByUsuarioAndThirtyDays(Saniusuario usuario, Timestamp lastThirtyDays);

    @Transactional
    Sanimovimiento save(Sanimovimiento sanimovimiento);
}
