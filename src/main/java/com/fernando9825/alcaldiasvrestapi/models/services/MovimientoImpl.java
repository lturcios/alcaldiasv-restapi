package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.IMovimientoDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.IUserDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Movimiento;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IMovimientoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoImpl implements IMovimientoService {

    private final IMovimientoDao movimientoDao;
    private final IUserDao userDao;

    public MovimientoImpl(IMovimientoDao movimientoDao, IUserDao userDao) {
        this.movimientoDao = movimientoDao;
        this.userDao = userDao;
    }

    @Override
    public List<Movimiento> findAllByUsuarioEmail(String usuarioEmail) {
        return this.movimientoDao.findAllByUsuario(this.userDao.findById(usuarioEmail).orElse(null));
    }

    @Override
    public Movimiento save(Movimiento movimiento) {
        return this.movimientoDao.save(movimiento);
    }

}
