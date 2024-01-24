package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Parkubicacion;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IParkUbicacionService;
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
public class ParkUbicacionController {

    private final IParkUbicacionService parkUbicacionService;

    @Autowired
    public ParkUbicacionController(IParkUbicacionService parkUbicacionService) {
        this.parkUbicacionService = parkUbicacionService;
    }

    @GetMapping(path = "parkubicacion/{institucionId}")
    public ResponseEntity<?> findByInstitucionId(
            @PathVariable short institucionId
    ) {
        List<Parkubicacion> parkubicaciones =
                this.parkUbicacionService.findByInstitucionId(institucionId);
        return (!parkubicaciones.isEmpty()) ? new ResponseEntity<>(parkubicaciones, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
