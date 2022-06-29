package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Servicio;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IRutaService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class ServicioController {

    private final IServicioService servicioService;
    private final IRutaService rutaService;

    @Autowired
    public ServicioController(IServicioService servicioService, IRutaService rutaService) {
        this.servicioService = servicioService;
        this.rutaService = rutaService;
    }

    @GetMapping(path = "servicios/{institucionId}/{usuarioEmail}")
    public ResponseEntity<?> findByInstitucionIdAndUsuarioEmail(
            @PathVariable short institucionId,
            @PathVariable String usuarioEmail){
        if(!rutaService.findAllByInstitucionIdAndUsuarioEmail(institucionId, usuarioEmail).isEmpty()) {
            List<Servicio> servicios = this.servicioService.findByInstitucionIdAndUsuarioEmail(institucionId, usuarioEmail);
            return (!servicios.isEmpty()) ? new ResponseEntity<>(servicios, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            List<Servicio> servicios = this.servicioService.findByInstitucionId(institucionId);
            return (!servicios.isEmpty()) ? new ResponseEntity<>(servicios, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
