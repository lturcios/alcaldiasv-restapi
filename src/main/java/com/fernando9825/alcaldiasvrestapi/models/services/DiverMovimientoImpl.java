package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IDiverMovimientoDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.IDiverUserDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Divermovimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.Diverusuario;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IDiverMovimientoService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class DiverMovimientoImpl implements IDiverMovimientoService {

    private final IDiverMovimientoDao diverMovimientoDao;
    private final IDiverUserDao diverUserDao;

    public DiverMovimientoImpl(
            IDiverMovimientoDao diverMovimientoDao,
            IDiverUserDao diverUserDao
    ) {
        this.diverMovimientoDao = diverMovimientoDao;
        this.diverUserDao = diverUserDao;
    }

    @Override
    public List<Divermovimiento> findAllByUsuarioEmail(String usuarioEmail) {
        return this.diverMovimientoDao.findAllByUsuario(this.diverUserDao.findById(usuarioEmail).orElse(null));
    }

    @Override
    public List<Divermovimiento> findAllByUsuarioAndThirtyDays(Diverusuario usuario, Timestamp lastThirtyDays) {
        return this.diverMovimientoDao.findAllByUsuarioAndThirtyDays(usuario, lastThirtyDays).orElse(null);
    }

    @Override
    public Divermovimiento save(Divermovimiento divermovimiento) {
        return this.diverMovimientoDao.save(divermovimiento);
    }
}
