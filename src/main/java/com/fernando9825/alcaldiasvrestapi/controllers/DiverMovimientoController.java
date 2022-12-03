package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.DiverMovimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.DiverUbicacion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Usuario;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IDiverMovimientoService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IDiverUbicacionService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IUserService;
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
public class DiverMovimientoController {

    private final IDiverMovimientoService diverMovimientoService;
    private final IUserService userService;
    private final IDiverUbicacionService diverUbicacionService;

    public DiverMovimientoController(
            IDiverMovimientoService diverMovimientoService,
            IUserService userService,
            IDiverUbicacionService diverUbicacionService)
    {
        this.diverMovimientoService = diverMovimientoService;
        this.userService = userService;
        this.diverUbicacionService = diverUbicacionService;
    }

    @GetMapping(path = "divermovimientos")
    public ResponseEntity<?> getAllDiverMovimientosByUsuarioEmail(
            @RequestParam(name = "email") String usuarioEmail
    ){
        Usuario diverusuario = this.userService.findById(usuarioEmail);

        if(diverusuario != null){
            return new ResponseEntity<>(
                    this.diverMovimientoService.findAllByUsuarioEmail(usuarioEmail), HttpStatus.OK);
        } else {
            Map<String, Object> message = new HashMap<>();
            message.put("message", "User " + usuarioEmail + "does not exists");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "divermovimientos/last-fifteen")
    public ResponseEntity<?> getAllDiverMovimientosOfLastFifteenDaysByUsuarioEmail(
            @RequestParam(name = "email") String usuarioEmail){
        Usuario diverusuario = this.userService.findById(usuarioEmail);

        if(diverusuario != null) {
            Date fechaActual = new Date();
            Duration temporalAmount = Duration.ofDays(7);
            Timestamp fechaMenosDias =
                    Timestamp.from(Date.from(
                            fechaActual.toInstant().minus(temporalAmount)).toInstant());

            List<DiverMovimiento> divermovimientos =
                    this.diverMovimientoService.findAllByUsuarioAndFechahorapago(diverusuario, fechaMenosDias);

            return new ResponseEntity<>(divermovimientos, HttpStatus.OK);
        } else {
            Map<String, Object> message = new HashMap<>();
            message.put("message", "User " + usuarioEmail + " does not exists");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "divermovimientos")
    public ResponseEntity<?> insertDiverMovimiento(
            @Size(min = 8) @RequestParam String pagoId,
            @RequestParam Integer diverubicacionId,
            @RequestParam Integer codigoPresupuestario,
            @RequestParam Double precioUnitario,
            @RequestParam Double precioFiestas,
            @RequestParam String fechaHoraPago,
            @RequestParam(required = false) String observaciones,
            @RequestParam String usuarioEmail,
            @RequestParam String serieInicial,
            @RequestParam String serieFinal){

        Map<String, Object> response = new HashMap<>();

        DiverUbicacion diverubicacion = this.diverUbicacionService.findById(diverubicacionId);
        Usuario diverusuario = this.userService.findById(usuarioEmail);

        SimpleDateFormat sdfFechaHoraPago = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date fechaHoraPagoDate;

        try{
            fechaHoraPagoDate = sdfFechaHoraPago.parse(fechaHoraPago);
            Timestamp timestamp = new Timestamp(fechaHoraPagoDate.getTime());

            if(diverusuario != null && diverubicacion != null){
                DiverMovimiento divermovimiento = new DiverMovimiento(
                        pagoId, diverubicacion, codigoPresupuestario,
                        precioUnitario, precioFiestas, timestamp, observaciones,
                        serieInicial, serieFinal, diverusuario);
                this.diverMovimientoService.save(divermovimiento);
                response.put("status", HttpStatus.CREATED.value());
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            } else {
                response.put("status", HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

        } catch (ParseException e) {
            e.printStackTrace();
            response.put("status", HttpStatus.BAD_REQUEST.value());
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
