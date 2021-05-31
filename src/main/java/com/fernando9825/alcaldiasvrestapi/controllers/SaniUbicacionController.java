package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Saniubicacion;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ISaniUbicacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class SaniUbicacionController {

    private final ISaniUbicacionService saniubicacionService;

    public SaniUbicacionController(ISaniUbicacionService saniubicacionService) {
        this.saniubicacionService = saniubicacionService;
    }

    @GetMapping(path = "saniubicacion/{institucionId}")
    public ResponseEntity<?> findByInstitucionId(@PathVariable short institucionId){
        List<Saniubicacion> saniubicaciones = this.saniubicacionService.findByInstitucionId(institucionId);
        return (!saniubicaciones.isEmpty()) ? new ResponseEntity<>(saniubicaciones, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
