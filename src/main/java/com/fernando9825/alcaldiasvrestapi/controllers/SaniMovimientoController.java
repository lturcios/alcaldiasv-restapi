package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Sanimovimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.Saniubicacion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Saniusuario;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ISaniMovimientoService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ISaniUbicacionService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ISaniUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/")
public class SaniMovimientoController {

    private final ISaniMovimientoService sanimovimientoService;
    private final ISaniUserService saniuserService;
    private final ISaniUbicacionService saniubicacionService;

    public SaniMovimientoController(ISaniMovimientoService sanimovimientoService,
                                    ISaniUserService saniuserService,
                                    ISaniUbicacionService saniubicacionService) {
        this.sanimovimientoService = sanimovimientoService;
        this.saniuserService = saniuserService;
        this.saniubicacionService = saniubicacionService;
    }

    @GetMapping(path = "sanimovimientos")
    public ResponseEntity<?> getAllSaniMovimientosByUsuarioEmail(@RequestParam(name = "email") String usuarioEmail){
        Saniusuario saniusuario = this.saniuserService.findById(usuarioEmail);

        if ( saniusuario != null) {
            return new ResponseEntity<>(this.sanimovimientoService.findAllByUsuarioEmail(usuarioEmail),
                    HttpStatus.OK);
        } else {
            Map<String, Object> message = new HashMap<>();
            message.put("message", "User " + usuarioEmail + " does not exists");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "sanimovimientos/last-fifteen")
    public ResponseEntity<?> getAllSaniMovimientosOfLastFifteenDaysByUsuarioEmail(
            @RequestParam(name = "email") String usuarioEmail){
        Saniusuario saniusuario = this.saniuserService.findById(usuarioEmail);

        if (saniusuario != null) {
            Date fechaActual = new Date();
            Duration temporalAmount = Duration.ofHours(15);
            Timestamp fechaMenosDias = Timestamp
                    .from(Date.from(fechaActual.toInstant().minus(temporalAmount))
                            .toInstant());

            List<Sanimovimiento> sanimovimientos =
                    this.sanimovimientoService.findAllByUsuarioAndThirtyDays(saniusuario, fechaMenosDias);

            return new ResponseEntity<>(sanimovimientos, HttpStatus.OK);
        } else {
            Map<String, Object> message = new HashMap<>();
            message.put("message", "User " + usuarioEmail + " does not exists");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "sanimovimientos")
    public ResponseEntity<?> insertSaniMovimiento(
            @Size(min = 8) @RequestParam String pagoId,
            @RequestParam Integer saniubicacionId,
            @RequestParam Integer codigoPresupuestario,
            @RequestParam Double precioUnitario,
            @RequestParam String fechaHoraPago,
            @RequestParam(required = false) String observaciones,
            @RequestParam String usuarioEmail,
            @RequestParam String serieInicial,
            @RequestParam String serieFinal,
            @RequestParam String genero){

        Map<String, Object> response = new HashMap<>();

        Saniubicacion saniubicacion = this.saniubicacionService.findById(saniubicacionId);
        Saniusuario saniusuario = this.saniuserService.findById(usuarioEmail);

        SimpleDateFormat sdfFechaHoraPago = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        Date fechaHoraPagoDate;

        try {
            fechaHoraPagoDate = sdfFechaHoraPago.parse(fechaHoraPago);
            Timestamp timestamp = new Timestamp(fechaHoraPagoDate.getTime());

            if (saniusuario != null && saniubicacion != null) {
                Sanimovimiento sanimovimiento = new Sanimovimiento(
                        pagoId, saniubicacion, codigoPresupuestario, precioUnitario,
                        timestamp, observaciones, saniusuario,
                        serieInicial, serieFinal, genero);

                this.sanimovimientoService.save(sanimovimiento);
                response.put("status", HttpStatus.CREATED.value());
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            } else {
                // codigo si falla algo (no llega el usuario)
                response.put("status", HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

        }catch (ParseException e) {
            e.printStackTrace();
            response.put("status", HttpStatus.BAD_REQUEST.value());
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
