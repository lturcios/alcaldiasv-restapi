package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IParkMovimientoDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.IParkUserDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Parkmovimiento;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IParkMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ParkMovimientoImpl implements IParkMovimientoService {

    private final IParkMovimientoDao parkMovimientoDao;
    private final IParkUserDao parkUserDao;

    @Autowired
    public ParkMovimientoImpl(
            IParkMovimientoDao parkMovimientoDao,
            IParkUserDao parkUserDao
    ) {
        this.parkMovimientoDao = parkMovimientoDao;
        this.parkUserDao = parkUserDao;
    }

    @Override
    public List<Parkmovimiento> findAllByUsuarioEmail(String usuarioEmail) {
        return this.parkMovimientoDao.findAllByUsuarioEntrada(usuarioEmail);
    }

    @Override
    public List<Parkmovimiento> findAllByUsuarioAndFechaHorapago(String parkusuario, Timestamp fechaHorapago) {
        return this.parkMovimientoDao.findAllByUsuarioAndFechaHorapago(parkusuario, fechaHorapago).orElse(null);
    }

    @Override
    public List<Parkmovimiento> findAllByUsuarioAndFechaHoraentra(String parkusuario, Timestamp fechaHoraentra) {
        return this.parkMovimientoDao.findAllByUsuarioAndFechaHoraentra(parkusuario, fechaHoraentra).orElse(null);
    }

    @Override
    public List<Parkmovimiento> findAllByUbicacionId(Integer ubicacionId, Timestamp fechaHoraentra) {
        return this.parkMovimientoDao.findAllByUbicacion(ubicacionId, fechaHoraentra).orElse(null);
    }

    @Override
    public List<Parkmovimiento> findAllByUbicacionAndFechaHorasaleIsEmpty(Integer ubicacionId) {
        return this.parkMovimientoDao.findAllByUbicacionAndFechaHorasaleIsEmpty(ubicacionId).orElse(null);
    }

    @Override
    public List<Parkmovimiento> findAllByUbicacionAndFechaHorasaleIsEmptyE(Integer ubicacionId) {
        return this.parkMovimientoDao.findAllByUbicacionAndFechaHorasaleIsEmptyE(ubicacionId).orElse(null);
    }

    @Override
    public void updateAllByUbicacionAndFechaHorasaleIsEmpty(Integer ubicacionId, String observaciones) {
        this.parkMovimientoDao.updateAllByUbicacionAndFechaHorasaleIsEmpty(ubicacionId, observaciones);
    }

    @Override
    public Parkmovimiento findById(String pagoId) {
        return this.parkMovimientoDao.findByPagoId(pagoId);
    }

    @Override
    public Parkmovimiento save(Parkmovimiento parkmovimiento) {
        return this.parkMovimientoDao.save(parkmovimiento);
    }
}
