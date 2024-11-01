package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Parkmovimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.Parkubicacion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Parkusuario;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IParkMovimientoService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IParkUbicacionService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IParkUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
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
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "/api/")
public class ParkMovimientoController {

    private final IParkMovimientoService parkMovimientoService;
    private final IParkUserService parkUserService;
    private final IParkUbicacionService parkUbicacionService;

    public ParkMovimientoController(
            IParkMovimientoService parkMovimientoService,
            IParkUserService parkUserService,
            IParkUbicacionService parkUbicacionService
    ) {
        this.parkMovimientoService = parkMovimientoService;
        this.parkUserService = parkUserService;
        this.parkUbicacionService = parkUbicacionService;
    }

    @GetMapping(path = "parkmovimiento")
    public ResponseEntity<Parkmovimiento> getParkMovimiento(
            @RequestParam(name = "pagoId") String pagoId) {
        Parkmovimiento parkmovimiento = this.parkMovimientoService.findById(pagoId);
        if (parkmovimiento == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(parkmovimiento, HttpStatus.OK);
        }
    }

    @GetMapping(path = "parkmovimientos")
    public ResponseEntity<?> findAllByUsuarioEmail(
            @RequestParam(name = "email") String usuarioEmail) {
        Parkusuario parkusuario = this.parkUserService.findById(usuarioEmail);

        if(parkusuario != null){
            return new ResponseEntity<>(this.parkMovimientoService.findAllByUsuarioEmail(usuarioEmail), HttpStatus.OK);
        } else {
            Map<String, Object> message = new HashMap<>();
            message.put("message", "User " + usuarioEmail + " does not exists");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "parkmovimientos/last-five")
    public ResponseEntity<?> findAllByUsuarioAndFechaHorapago(
            @RequestParam(name = "email") String usuarioEmail) {

        Parkusuario parkusuario = this.parkUserService.findById(usuarioEmail);

        if(usuarioEmail != null && !usuarioEmail.isEmpty()){
            Date fechaActual = new Date();
            Duration temporalAmount = Duration.ofDays(3);
            Timestamp fechaMenosDias = Timestamp
                    .from(Date.from(fechaActual.toInstant().minus(temporalAmount))
                            .toInstant());

            List<Parkmovimiento> parkmovimientos =
                    this.parkMovimientoService.findAllByUsuarioAndFechaHoraentra(usuarioEmail, fechaMenosDias);

            return new ResponseEntity<>(parkmovimientos, HttpStatus.OK);

        } else {
            Map<String, Object> message = new HashMap<>();
            message.put("message", "User " + usuarioEmail + " does not exists");
            return  new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "parkmovimientos/ubicacion")
    public ResponseEntity<?> findAllByUbicacionId(
            @RequestParam(name = "ubicacionId") Integer ubicacionId) {

        Date fechaActual = new Date();
        Duration temporalAmount = Duration.ofDays(7);
        Timestamp dateBefore = Timestamp.from(Date.from(fechaActual.toInstant().minus(temporalAmount)).toInstant());

        List<Parkmovimiento> parkmovimientos = this.parkMovimientoService.findAllByUbicacionId(ubicacionId, dateBefore);
        return new ResponseEntity<>(parkmovimientos, HttpStatus.OK);
    }

    @GetMapping(path = "parkmovimientos/pendientes/ubicacion")
    public ResponseEntity<?> findAllByUbicacionIdWithoutSalida(
            @RequestParam(name = "ubicacionId") Integer ubicacionId,
            @RequestParam(name = "pendiente") String pendiente) {
        List<Parkmovimiento> parkmovimientos;
        if(pendiente.equals("N")){
            parkmovimientos = this.parkMovimientoService.findAllByUbicacionAndFechaHorasaleIsEmptyE(ubicacionId);
        } else {
            parkmovimientos = this.parkMovimientoService.findAllByUbicacionAndFechaHorasaleIsEmpty(ubicacionId);
            this.parkMovimientoService.updateAllByUbicacionAndFechaHorasaleIsEmpty(ubicacionId, "D");
        }
        return new ResponseEntity<>(parkmovimientos, HttpStatus.OK);
    }

    @Async
    @PostMapping(path = "parkmovimientos")
    public CompletableFuture<ResponseEntity<?>> save(
            @Size(min =8) @RequestParam String pagoId,
            @RequestParam Short parkubicacionId,
            @RequestParam Integer codigoPresupuestario,
            @RequestParam (required = false) String placa,
            @RequestParam String fechaHoraentra,
            @RequestParam(required = false) String fechaHorasale,
            @RequestParam Double precioUnitario,
            @RequestParam(required = false) Integer tiempoMinutos,
            @RequestParam(required = false) Double montoTotal,
            @RequestParam String serieEntrada,
            @RequestParam(required = false) String serieSalida,
            @RequestParam(required = false) String fechaHorapago,
            @RequestParam(required = false) String observaciones,
            @RequestParam String usuarioEmailEntrada,
            @RequestParam(required = false) String usuarioEmailSalida) {

        Map<String, Object> response = new HashMap<>();
        Parkubicacion parkubicacion = this.parkUbicacionService.findById(parkubicacionId);
        Parkusuario parkusuarioEntrada = this.parkUserService.findById(usuarioEmailEntrada);
        Parkmovimiento parkmovimiento = this.parkMovimientoService.findById(pagoId);
        Parkusuario parkusuarioSalida;
        String usuarioSalida;

        if(usuarioEmailSalida != null) {
            parkusuarioSalida = this.parkUserService.findById(usuarioEmailSalida);
            if (parkusuarioSalida == null) {
                usuarioSalida = null;
                response.put("status", HttpStatus.BAD_REQUEST.value());
                response.put("error", "User does not exists");
                return CompletableFuture.completedFuture(new ResponseEntity<>(response, HttpStatus.BAD_REQUEST));
            } else {
                usuarioSalida = parkusuarioSalida.getEmail();
            }
        } else {
            usuarioSalida = null;
            parkusuarioSalida = null;
        }

        SimpleDateFormat sdfFechaHora = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        Date fechaHoraDatePago;
        Date fechaHoraDateEntra;
        Date fechaHoraDateSale;
        Timestamp pago = null;
        Timestamp sale = null;
        Timestamp entra = null;

        try {
            if (fechaHorapago != null) {
                fechaHoraDatePago = sdfFechaHora.parse(fechaHorapago);
                pago = new Timestamp(fechaHoraDatePago.getTime());
            }

            if (fechaHorasale != null) {
                fechaHoraDateSale = sdfFechaHora.parse(fechaHorasale);
                sale = new Timestamp(fechaHoraDateSale.getTime());
            }

            fechaHoraDateEntra = sdfFechaHora.parse(fechaHoraentra);
            entra = new Timestamp(fechaHoraDateEntra.getTime());

        } catch (ParseException e) {
            System.out.println(e.getMessage());
            response.put("status", HttpStatus.BAD_REQUEST.value());
            response.put("error", e.getMessage());
            return CompletableFuture.completedFuture(new ResponseEntity<>(response, HttpStatus.BAD_REQUEST));
        }

        if(parkmovimiento == null) {
            Timestamp finalEntra = entra;
            Timestamp finalSale = sale;
            Timestamp finalPago = pago;
            return CompletableFuture.supplyAsync(() -> {
                try {
                    if (parkusuarioEntrada != null && parkubicacion != null) {
                        Parkmovimiento parkmovimientoNuevo = new Parkmovimiento(
                                pagoId, parkubicacion, codigoPresupuestario, placa, finalEntra, finalSale, precioUnitario,
                                tiempoMinutos, montoTotal, serieEntrada, serieSalida, finalPago,
                                observaciones, parkusuarioEntrada.getEmail(), parkusuarioSalida != null ? parkusuarioSalida.getEmail() : null);
                        this.parkMovimientoService.save(parkmovimientoNuevo);
                        response.put("status", HttpStatus.CREATED.value());
                        return new ResponseEntity<>(response, HttpStatus.CREATED);
                    } else {
                        response.put("status", HttpStatus.BAD_REQUEST.value());
                        response.put("error", "User or location does not exists");
                        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
                    }
                } catch (Exception e) {
                    response.put("status", HttpStatus.NOT_FOUND.value());
                    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
                }
            });
        } else {
            Timestamp finalPago1 = pago;
            Timestamp finalSale1 = sale;
            return CompletableFuture.supplyAsync(() -> {
                try {
                    parkmovimiento.setFechaHorapago(finalPago1);
                    parkmovimiento.setFechaHorasale(finalSale1);
                    parkmovimiento.setSerieEntrada(serieEntrada);
                    parkmovimiento.setSerieSalida(serieSalida);
                    parkmovimiento.setTiempoMinutos(tiempoMinutos);
                    parkmovimiento.setMontoTotal(montoTotal);
                    parkmovimiento.setUsuarioSalida(usuarioSalida);
                    this.parkMovimientoService.save(parkmovimiento);
                    response.put("status", HttpStatus.ACCEPTED.value());
                    return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
                } catch (Exception e) {
                    response.put("status", HttpStatus.NOT_FOUND.value());
                    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
                }
            });
        }
    }

}
