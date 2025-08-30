package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.TuriDetalle;
import com.fernando9825.alcaldiasvrestapi.models.entity.TuriMovimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITuriDetalleDao extends JpaRepository<TuriDetalle, Long> {

    List<TuriDetalle> findAllByPagoId(TuriMovimiento pagoId);

    @Modifying
    @Query(value = "delete from TuriDetalle td where td.pagoId = ?1")
    void deleteAllByPagoId(TuriMovimiento pagoId);

}
