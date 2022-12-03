package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IDiverMovimientoDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.IUserDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.DiverMovimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.Usuario;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IDiverMovimientoService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class DiverMovimientoImpl implements IDiverMovimientoService {

    private final IDiverMovimientoDao diverMovimientoDao;
    private final IUserDao userDao;

    public DiverMovimientoImpl(IDiverMovimientoDao diverMovimientoDao, IUserDao userDao) {
        this.diverMovimientoDao = diverMovimientoDao;
        this.userDao = userDao;
    }

    @Override
    public List<DiverMovimiento> findAllByUsuarioEmail(String usuarioEmail) {
        return this.diverMovimientoDao.findAllByUsuario(this.userDao.findById(usuarioEmail).orElse(null));
    }

    @Override
    public List<DiverMovimiento> findAllByUsuarioAndFechahorapago(Usuario usuario, Timestamp fechahorapago) {
        return this.diverMovimientoDao.findAllByUsuarioAndFechaHorapago(usuario, fechahorapago).orElse(null);
    }

    @Override
    public DiverMovimiento save(DiverMovimiento diverMovimiento) {
        return this.diverMovimientoDao.save(diverMovimiento);
    }
}
