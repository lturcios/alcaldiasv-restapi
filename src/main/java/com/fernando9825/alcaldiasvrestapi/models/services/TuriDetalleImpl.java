package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.ITuriDetalleDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.TuriDetalle;
import com.fernando9825.alcaldiasvrestapi.models.entity.TuriMovimiento;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ITuriDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuriDetalleImpl implements ITuriDetalleService {

    private final ITuriDetalleDao turiDetalleDao;

    @Autowired
    public TuriDetalleImpl(ITuriDetalleDao turiDetalleDao) {
        this.turiDetalleDao = turiDetalleDao;
    }

    @Override
    public List<TuriDetalle> findAllByPagoId(TuriMovimiento pagoId) {
        return this.turiDetalleDao.findAllByPagoId(pagoId);
    }

    @Override
    public TuriDetalle save(TuriDetalle turiDetalle) {
        return this.turiDetalleDao.save(turiDetalle);
    }

    @Override
    public void deleteAllByPagoId(TuriMovimiento pagoId) {
        this.turiDetalleDao.deleteAllByPagoId(pagoId);
    }

    @Override
    public void deleteById(Long id) {
        this.turiDetalleDao.deleteById(id);
    }

    @Override
    public List<TuriDetalle> findAll() {
        return this.turiDetalleDao.findAll();
    }

    @Override
    public TuriDetalle findById(Long id) {
        return this.turiDetalleDao.findById(id).orElse(null);
    }
}
