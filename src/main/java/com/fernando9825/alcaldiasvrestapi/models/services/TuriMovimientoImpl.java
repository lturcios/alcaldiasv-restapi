package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.dao.ITuriMovimientoDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.ITuriUbicacionDao;
import com.fernando9825.alcaldiasvrestapi.models.dao.ITuriUserDao;
import com.fernando9825.alcaldiasvrestapi.models.dto.TuriDetalleDTO;
import com.fernando9825.alcaldiasvrestapi.models.dto.TuriMovimientoDTO;
import com.fernando9825.alcaldiasvrestapi.models.entity.TuriDetalle;
import com.fernando9825.alcaldiasvrestapi.models.entity.TuriMovimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.TuriUbicacion;
import com.fernando9825.alcaldiasvrestapi.models.entity.TuriUser;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ITuriMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TuriMovimientoImpl implements ITuriMovimientoService {

    private final ITuriMovimientoDao turiMovimientoDao;
    private final ITuriUserDao turiUserDao;
    private final ITuriUbicacionDao turiUbicacionDao;

    @Autowired
    public TuriMovimientoImpl(ITuriMovimientoDao turiMovimientoDao, ITuriUserDao turiUserDao, ITuriUbicacionDao turiUbicacionDao) {
        this.turiMovimientoDao = turiMovimientoDao;
        this.turiUserDao = turiUserDao;
        this.turiUbicacionDao = turiUbicacionDao;
    }

    @Override
    public List<TuriMovimiento> findAllByTuriUser(String usuarioEmail) {
        return this.turiMovimientoDao.findAllByUsuario(this.turiUserDao.findById(usuarioEmail).orElse(null));
    }

    @Override
    public List<TuriMovimiento> findAllByUsuarioAndFechaHorapago(TuriUser turiUser, Timestamp fechahorapago) {
        return this.turiMovimientoDao.findAllByUsuarioAndFechaHorapago(turiUser, fechahorapago).orElse(null);
    }

    @Override
    public List<TuriMovimiento> findAllByUbicacion(TuriUbicacion ubicacion) {
        return this.turiMovimientoDao.findAllByUbicacion(ubicacion);
    }

    public TuriMovimiento crearMovimiento(TuriMovimientoDTO dto) {
        // Validar que el usuario exista
        TuriUser usuario = turiUserDao.findById(dto.getUsuarioEmail())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado: " + dto.getUsuarioEmail()));

        // Validar que la ubicación exista (si se proporciona)
        TuriUbicacion ubicacion = null;
        if (dto.getUbicacionId() != null) {
            ubicacion = turiUbicacionDao.findById(dto.getUbicacionId())
                    .orElseThrow(() -> new IllegalArgumentException("Ubicación no encontrada: " + dto.getUbicacionId()));
        }

        // Crear la entidad TuriMovimiento
        TuriMovimiento movimiento = new TuriMovimiento();
        movimiento.setPagoId(dto.getPagoId());
        movimiento.setUbicacion(ubicacion);
        movimiento.setReferencia(dto.getReferencia());
        movimiento.setMontoTotal(dto.getMontoTotal());
        movimiento.setObservaciones(dto.getObservaciones());
        movimiento.setNumeroSerie(dto.getNumeroSerie());
        movimiento.setUsuario(usuario);

        // Convertir fechas de String a Date
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            movimiento.setFechaHorapago(formatter.parse(dto.getFechaHorapago()));

            if (dto.getFechaHoraAnula() != null && !dto.getFechaHoraAnula().isEmpty()) {
                movimiento.setFechaHoraAnula(formatter.parse(dto.getFechaHoraAnula()));
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato de fecha inválido. Use: yyyy-MM-dd'T'HH:mm:ss");
        }

        // Crear los detalles
        List<TuriDetalle> detalles = new ArrayList<>();
        for (TuriDetalleDTO detalleDTO : dto.getDetalles()) {
            TuriDetalle detalle = new TuriDetalle();
            detalle.setPagoId(movimiento); // Establecer la relación
            detalle.setCodigoPresupuestario(detalleDTO.getCodigoPresupuestario());
            detalle.setCantidad(detalleDTO.getCantidad());
            detalle.setPrecioUnitario(detalleDTO.getPrecioUnitario());
            detalle.setPrecioTotal(detalleDTO.getPrecioTotal());

            detalles.add(detalle);
        }

        movimiento.setDetalles(detalles);

        // Guardar (Cascade.ALL se encarga de guardar los detalles también)
        return turiMovimientoDao.save(movimiento);
    }
}
