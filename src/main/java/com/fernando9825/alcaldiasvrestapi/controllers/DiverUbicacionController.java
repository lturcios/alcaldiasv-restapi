package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Diverubicacion;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IDiverUbicacionService;
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
public class DiverUbicacionController {

    private final IDiverUbicacionService diverUbicacionService;

    @Autowired
    public DiverUbicacionController(IDiverUbicacionService diverUbicacionService) {
        this.diverUbicacionService = diverUbicacionService;
    }

    @GetMapping(path = "diverubicacion/{institucionId}")
    public ResponseEntity<?> findByInstitucionId(
            @PathVariable short institucionId
    ){
        List<Diverubicacion> diverubicaciones =
                this.diverUbicacionService.findByInstitucionId(institucionId);
        return (!diverubicaciones.isEmpty()) ? new ResponseEntity<>(diverubicaciones, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
