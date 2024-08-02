package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.*;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

@RestController
@RequestMapping(path = "/api/")
public class MovimientoController {

    private final IMovimientoService movimientoService;
    private final IUserService userService;
    private final IAsignacionService asignacionService;
    private final IContribuyenteService contribuyenteService;
    private final IFinanciamientoService financiamientoService;


    public MovimientoController(IMovimientoService movimientoService,
                                IUserService userService,
                                IAsignacionService asignacionService,
                                IContribuyenteService contribuyenteService,
                                IFinanciamientoService financiamientoService) {
        this.movimientoService = movimientoService;
        this.userService = userService;
        this.asignacionService = asignacionService;
        this.contribuyenteService = contribuyenteService;
        this.financiamientoService = financiamientoService;
    }

    // obtener todas los movimientos por id del usuario que los efectuo
    @GetMapping(path = "movimientos")
    public ResponseEntity<?> getAllMovimientosByUsuarioEmail(@RequestParam(name = "email") String usuarioEmail) {
        Usuario usuario = this.userService.findById(usuarioEmail);

        if (usuario != null) {
            return new ResponseEntity<>(this.movimientoService.findAllByUsuarioEmail(usuarioEmail),
                    HttpStatus.OK);
        } else {
            Map<String, Object> message = new HashMap<>();
            message.put("message", "User " + usuarioEmail + " does not exists");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping(path = "movimientos/last-thirty")
    public ResponseEntity<?> getAllMovimientosOfLastFifteenDaysByUsuarioEmail(@RequestParam(name = "email") String usuarioEmail) {
        Usuario usuario = this.userService.findById(usuarioEmail);

        if (usuario != null) {

            Date fechaActual = new Date();

            Duration temporalAmount = Duration.ofDays(7);
            Timestamp fechaMenosLastDays = Timestamp.from(Date.from(fechaActual.toInstant().minus(temporalAmount)).toInstant());
            List<Movimiento> movimientos = this.movimientoService
                    .findAllByUsuarioAndThirtyDays(usuario, fechaMenosLastDays);
            return new ResponseEntity<>(movimientos, HttpStatus.OK);
        } else {
            Map<String, Object> message = new HashMap<>();
            message.put("message", "User " + usuarioEmail + " does not exists");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

    }

    // Guardar movimiento
    @PostMapping(path = "movimientos")
    public ResponseEntity<?> insertMovimiento(
            @Size(min = 8, max = 8) @RequestParam String pagoId,
            @RequestParam(required = false) Integer asignacionId,
            @RequestParam String ultimoPago,
            @RequestParam(required = false) String observaciones,
            @RequestParam Double precioUnitario,
            @RequestParam Double tarifaUnitario,
            @RequestParam Double montoTotal,
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin,
            @RequestParam String fechaHoraPago,
            @RequestParam(required = false) String fechaHoraAnula,
            @RequestParam String usuarioEmail,
            @RequestParam String serieInicial,
            @RequestParam String serieFinal,
            @RequestParam(required = false) Double saldoActual,
            @RequestParam(required = false) Double saldoAnterior,
            @RequestParam(required = false) String tipo
            ) {

        Map<String, Object> response = new HashMap<>();

        Asignacion asignacion = null;
        if (asignacionId != null){
            asignacion = this.asignacionService.findById(asignacionId);
        }

        Usuario usuario = this.userService.findById(usuarioEmail);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        SimpleDateFormat sdfFechaHoraPago = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        Date ultimoPagoDate;
        Date fechaInicioDate;
        Date fechaFinDate;
        Date fechaHoraPagoDate;

        try {
            ultimoPagoDate = simpleDateFormat.parse(ultimoPago);
            fechaInicioDate = simpleDateFormat.parse(fechaInicio);
            fechaFinDate = simpleDateFormat.parse(fechaFin);

            fechaHoraPagoDate = sdfFechaHoraPago.parse(fechaHoraPago);
            Timestamp timestamp = new java.sql.Timestamp(fechaHoraPagoDate.getTime());
            // codigo del camino feliz
            if (asignacion != null && usuario != null) {
                if (tipo != null) {
                    switch (tipo) {
                        case "F":
                            Contribuyente contrifinan = this.contribuyenteService.findById(asignacion.getContribuyente());
                            Financiamiento financiamiento = this.financiamientoService.findByContribuyenteId(contrifinan.getId());
                            if (financiamiento != null) {
                                /* verificar que saldo en base de datos > saldo recibido */
                                if (financiamiento.getSaldoActual() > saldoActual) {
                                    financiamiento.setSaldoActual(saldoActual);
                                    financiamiento.setSaldoAnterior(saldoAnterior);
                                    financiamiento.setUltimoPago(fechaFinDate);
                                }
                            }
                            break;
                        case "A":
                            /*  verificar que la fecha del ultimo pago recibida, sea siempre la ultima */
                            /*
                            if (asignacion.getUltimoPago().getTime() < fechaFinDate.getTime()) {
                                asignacion.setUltimoPago(ultimoPagoDate);
                            }
                            */
                           break;
                    }
                } else {
                    /* Segun la version de la app, puede ser que no envíe el tipo => se tratará como Asignacion */
                    /* if (asignacion.getUltimoPago().getTime() < fechaFinDate.getTime()) {
                        asignacion.setUltimoPago(ultimoPagoDate);
                    }
                    */
                }

                Movimiento movimiento = new Movimiento(
                        pagoId,
                        asignacion,
                        precioUnitario,
                        tarifaUnitario,
                        montoTotal,
                        fechaInicioDate,
                        fechaFinDate,
                        timestamp,
                        observaciones,
                        usuario,
                        serieInicial,
                        serieFinal,
                        saldoActual,
                        saldoAnterior,
                        tipo);

                this.movimientoService.save(movimiento);
                response.put("status", HttpStatus.CREATED.value());

                return new ResponseEntity<>(response, HttpStatus.CREATED);
            } else if (asignacion == null && usuario != null){ // Vendedor ambulante
                Movimiento movimiento = new Movimiento(
                        pagoId,
                        null,
                        precioUnitario,
                        tarifaUnitario,
                        montoTotal,
                        fechaInicioDate,
                        fechaFinDate,
                        timestamp,
                        observaciones,
                        usuario,
                        serieInicial,
                        serieFinal,
                        saldoActual,
                        saldoAnterior,
                        tipo);

                this.movimientoService.save(movimiento);
                response.put("status", HttpStatus.CREATED.value());
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            } else {
                // codigo si falla algo
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




