package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.TuriUbicacion;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ITuriUbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/")
public class TuriUbicacionController {

    private final ITuriUbicacionService turiUbicacionService;

    @Autowired
    public TuriUbicacionController(ITuriUbicacionService turiUbicacionService) {
        this.turiUbicacionService = turiUbicacionService;
    }

    @GetMapping(path = "turiubicacion/{institucionId}")
    public ResponseEntity<?> findByInstitucionId(@PathVariable short institucionId) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", "No se encontraron ubicaciones para la institucion con id: " + institucionId);
        List<TuriUbicacion> turiUbicacions =
                this.turiUbicacionService.findByInstitucionId(institucionId);
        return (!turiUbicacions.isEmpty()) ? new ResponseEntity<>(turiUbicacions, HttpStatus.OK) : new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

}
