package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.dto.TuriMovimientoDTO;
import com.fernando9825.alcaldiasvrestapi.models.dto.TuriMovimientoResponseDTO;
import com.fernando9825.alcaldiasvrestapi.models.entity.TuriMovimiento;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ITuriDetalleService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ITuriMovimientoService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ITuriUbicacionService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ITuriUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class TuriMovimientoController {

    private final ITuriMovimientoService turiMovimientoService;
    private final ITuriDetalleService turiDetalleService;
    private final ITuriUserService turiUserService;

    @Autowired
    public TuriMovimientoController(ITuriMovimientoService turiMovimientoService, ITuriDetalleService turiDetalleService, ITuriUbicacionService turiUbicacionService, ITuriUserService turiUserService) {
        this.turiMovimientoService = turiMovimientoService;
        this.turiDetalleService = turiDetalleService;
        this.turiUserService = turiUserService;
    }

    @GetMapping(path = "turimovimientos/{usuarioEmail}")
    public ResponseEntity<?> getTuriMovimientosByUsuario(@PathVariable String usuarioEmail) {
        List<TuriMovimiento> turiMovimientos = this.turiMovimientoService.findAllByTuriUser(usuarioEmail);
        return (!turiMovimientos.isEmpty()) ? new ResponseEntity<>(turiMovimientos, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "turimovimientos")
    public ResponseEntity<TuriMovimientoResponseDTO> crearMovimiento(
            @Valid @RequestBody TuriMovimientoDTO movimientoDTO) {

        try {
            TuriMovimiento movimientoCreado = turiMovimientoService.crearMovimiento(movimientoDTO);

            TuriMovimientoResponseDTO response = new TuriMovimientoResponseDTO(
                    movimientoCreado.getPagoId(),
                    "Movimiento creado exitosamente",
                    true
            );

            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException e) {
            TuriMovimientoResponseDTO response = new TuriMovimientoResponseDTO(
                    null,
                    "Error de validación: " + e.getMessage(),
                    false
            );
            return ResponseEntity.badRequest().body(response);

        } catch (Exception e) {
            TuriMovimientoResponseDTO response = new TuriMovimientoResponseDTO(
                    null,
                    "Error interno del servidor: " + e.getMessage(),
                    false
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


}
