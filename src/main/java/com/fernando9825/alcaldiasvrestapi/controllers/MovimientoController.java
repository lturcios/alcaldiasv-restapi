package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Movimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.Usuario;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IAsignacionService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IContribuyenteService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IMovimientoService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/")
public class MovimientoController {

    private final IMovimientoService movimientoService;
    private final IUserService userService;
    private final IAsignacionService asignacionService;
    private final IContribuyenteService contribuyenteService;

    public MovimientoController(IMovimientoService movimientoService, IUserService userService, IAsignacionService asignacionService, IContribuyenteService contribuyenteService) {
        this.movimientoService = movimientoService;
        this.userService = userService;
        this.asignacionService = asignacionService;
        this.contribuyenteService = contribuyenteService;
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

    // Guardar movimiento
    @PostMapping(path = "movimientos")
    public ResponseEntity<?> insertMovimiento(@RequestBody Movimiento movimiento,
                                              BindingResult result) {

        if (result.hasErrors()){
            Map<String, Object> message = new HashMap<>();
            message.put("message", "solve the errors in order to save");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        this.movimientoService.save(movimiento);
        return new ResponseEntity<>(movimiento, HttpStatus.CREATED);
    }

    /*@PostMapping(path = "movimientos")
    public ResponseEntity<?> insertMovimiento(
            @RequestParam String pagoId,
            @RequestParam Long asignacionId,
            @RequestParam Double precioUnitario,
                @RequestParam Double tarifaUnitario,
            @RequestParam Double iva,
            @RequestParam Double montoTotal,
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin,
            @RequestParam String fechaHorapago,
            @RequestParam String usuarioEmail,
            @RequestParam(required = false) String fechaHoraAnula,
            @RequestParam(required = false) String observaciones) throws ParseException {


        Movimiento movimiento = new Movimiento(
                pagoId,
                this.asignacionService.findById(asignacionId),
                precioUnitario,
                tarifaUnitario,
                iva,
                montoTotal,
                new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio),
                new SimpleDateFormat("yyyy-MM-dd").parse(fechaFin),
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZ").parse(fechaHorapago),
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZ").parse(fechaHoraAnula),
                observaciones,
                this.userService.findById(usuarioEmail)
        );

        this.movimientoService.save(movimiento);
        return new ResponseEntity<>(movimiento, HttpStatus.CREATED);
    }*/
}
