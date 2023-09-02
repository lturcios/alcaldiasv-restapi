package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Parkmovimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.Parkubicacion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Parkusuario;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IParkMovimientoService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IParkUbicacionService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IParkUserService;
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

        if(parkusuario != null){
            Date fechaActual = new Date();
            Duration temporalAmount = Duration.ofDays(5);
            Timestamp fechaMenosDias = Timestamp
                    .from(Date.from(fechaActual.toInstant().minus(temporalAmount))
                            .toInstant());

            List<Parkmovimiento> parkmovimientos =
                    this.parkMovimientoService.findAllByUsuarioAndFechaHoraentra(parkusuario, fechaMenosDias);

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
        List<Parkmovimiento> parkmovimientos = this.parkMovimientoService.findAllByUbicacionId(ubicacionId);
        return new ResponseEntity<>(parkmovimientos, HttpStatus.OK);
    }

    @PostMapping(path = "parkmovimientos")
    public ResponseEntity<?> save(
            @Size(min =8) @RequestParam String pagoId,
            @RequestParam Short parkubicacionId,
            @RequestParam Integer codigoPresupuestario,
            @RequestParam String fechaHoraentra,
            @RequestParam(required = false) String fechaHorasale,
            @RequestParam Double precioUnitario,
            @RequestParam(required = false) Integer tiempoMinutos,
            @RequestParam(required = false) Double montoTotal,
            @RequestParam String serieEntrada,
            @RequestParam(required = false) String serieSalida,
            @RequestParam(required = false) String fechaHorapago,
            @RequestParam(required = false) String observaciones,
            @RequestParam String usuarioEmail
    ) {
        Map<String, Object> response = new HashMap<>();
        Parkubicacion parkubicacion = this.parkUbicacionService.findById(parkubicacionId);
        Parkusuario parkusuario = this.parkUserService.findById(usuarioEmail);
        Parkmovimiento parkmovimiento = this.parkMovimientoService.findById(pagoId);
                
        SimpleDateFormat sdfFechaHora = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        Date fechaHoraDatePago;
        Date fechaHoraDateEntra;
        Date fechaHoraDateSale;
        
        try {
            Timestamp pago = null;
            if(fechaHorapago != null) {
                fechaHoraDatePago = sdfFechaHora.parse(fechaHorapago);
                pago = new Timestamp(fechaHoraDatePago.getTime());
            }

            Timestamp sale = null;
            if(fechaHorasale != null) {
                fechaHoraDateSale = sdfFechaHora.parse(fechaHorasale);
                sale = new Timestamp(fechaHoraDateSale.getTime());
            }

            Timestamp entra = null;
            fechaHoraDateEntra = sdfFechaHora.parse(fechaHoraentra);
            entra = new Timestamp(fechaHoraDateEntra.getTime());
            
            if(parkmovimiento == null) {
                if (parkusuario != null && parkubicacion != null) {
                    Parkmovimiento parkmovimientoNuevo = new Parkmovimiento(
                            pagoId, parkubicacion, codigoPresupuestario, entra, sale, precioUnitario,
                            tiempoMinutos, montoTotal, serieEntrada, serieSalida, pago,
                            observaciones, parkusuario);
                    this.parkMovimientoService.save(parkmovimientoNuevo);
                    response.put("status", HttpStatus.CREATED.value());
                    return new ResponseEntity<>(response, HttpStatus.CREATED);
                } else {
                    // codigo si falla algo (no llega el usuario)
                    response.put("status", HttpStatus.NOT_FOUND.value());
                    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
                }
            } else {
                parkmovimiento.setFechaHorapago(pago);
                parkmovimiento.setFechaHorasale(sale);
                parkmovimiento.setSerieSalida(serieSalida);
                parkmovimiento.setTiempoMinutos(tiempoMinutos);
                parkmovimiento.setMontoTotal(montoTotal);
                this.parkMovimientoService.save(parkmovimiento);
                response.put("status", HttpStatus.ACCEPTED.value());
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
            }

        } catch (ParseException e){
            e.printStackTrace();
            response.put("status", HttpStatus.BAD_REQUEST.value());
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
