package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Parkmovimiento;
import com.fernando9825.alcaldiasvrestapi.models.entity.Parkusuario;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IParkMovimientoService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IParkUbicacionService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IParkUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
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

    public List<Parkmovimiento> findAllByUsuarioAndFechaHorapago(Parkusuario parkusuario, Timestamp fechaHorapago) {
        return parkMovimientoService.findAllByUsuarioAndFechaHorapago(parkusuario, fechaHorapago);
    }

    @Transactional
    public Parkmovimiento save(Parkmovimiento parkmovimiento) {
        return parkMovimientoService.save(parkmovimiento);
    }
}
