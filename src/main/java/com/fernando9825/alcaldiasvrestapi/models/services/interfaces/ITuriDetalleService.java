package com.fernando9825.alcaldiasvrestapi.models.services.interfaces;

import com.fernando9825.alcaldiasvrestapi.models.entity.TuriDetalle;
import com.fernando9825.alcaldiasvrestapi.models.entity.TuriMovimiento;

import java.util.List;

public interface ITuriDetalleService {

    List<TuriDetalle> findAllByPagoId(TuriMovimiento pagoId);

    TuriDetalle save(TuriDetalle turiDetalle);

    void deleteAllByPagoId(TuriMovimiento pagoId);

    void deleteById(Long id);

    List<TuriDetalle> findAll();

    TuriDetalle findById(Long id);


}
