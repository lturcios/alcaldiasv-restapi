package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Ruta;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IRutaService;
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
public class RutaController {

    private final IRutaService rutaService;

    @Autowired
    public RutaController(IRutaService rutaService) {
        this.rutaService = rutaService;
    }

    @GetMapping(path = "rutas/{institucionId}")
    public ResponseEntity<?> getAllRutasByInstitucionId(@PathVariable Long institucionId) {
        List<Ruta> rutas = this.rutaService.findByInstitucionId(institucionId);

        return (!rutas.isEmpty()) ? new ResponseEntity<>(rutas, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping(path = "rutas/{institucionId}/{usuarioEmail}")
    public ResponseEntity<?> getRutas(@PathVariable Long institucionId, @PathVariable String usuarioEmail) {
        List<Ruta> rutas = this.rutaService.findByInstitucionIdAndUsuarioEmail(institucionId, usuarioEmail);
        return (!rutas.isEmpty()) ? new ResponseEntity<>(rutas, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
