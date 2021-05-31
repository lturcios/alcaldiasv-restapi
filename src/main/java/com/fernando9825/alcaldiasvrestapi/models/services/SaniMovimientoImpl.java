package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.ISaniMovimientoDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.ISaniUserDao;
import com.fernando9825.alcaldiasvrestapi.models.entity.Sanimovimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.Saniusuario;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ISaniMovimientoService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class SaniMovimientoImpl implements ISaniMovimientoService {

    private final ISaniMovimientoDao sanimovimientoDao;
    private final ISaniUserDao saniuserDao;

    public SaniMovimientoImpl(ISaniMovimientoDao sanimovimientoDao, ISaniUserDao saniuserDao){
        this.sanimovimientoDao = sanimovimientoDao;
        this.saniuserDao = saniuserDao;
    }

    @Override
    public List<Sanimovimiento> findAllByUsuarioEmail(String usuarioEmail) {
        return this.sanimovimientoDao.findAllByUsuario(this.saniuserDao.findById(usuarioEmail).orElse(null));
    }

    @Override
    public List<Sanimovimiento> findAllByUsuarioAndThirtyDays(Saniusuario usuario, Timestamp lastThirtyDays) {
        return this.sanimovimientoDao.findAllByUsuarioAndThirtyDays(usuario, lastThirtyDays).orElse(null);
    }

    @Override
    public Sanimovimiento save(Sanimovimiento sanimovimiento) {
        return this.sanimovimientoDao.save(sanimovimiento);
    }
}
