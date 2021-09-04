package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Parktarifa;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IParkTarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class ParkTarifaController {

    private final IParkTarifaService parkTarifaService;

    @Autowired
    public ParkTarifaController(IParkTarifaService parkTarifaService) {
        this.parkTarifaService = parkTarifaService;
    }

    @GetMapping("parktarifas/{institucionId}")
    public List<Parktarifa> getAllParkTarifasByInstitucionId(@PathVariable short institucionId) {
        return parkTarifaService.getAllParkTarifasByInstitucionId(institucionId);
    }

    @GetMapping("parktarifas/{institucionId}/{parkubicacionId}")
    public List<Parktarifa> getAllParkTarifasByInstitucionIdAndUbicacion(
            @PathVariable short institucionId,
            @PathVariable int parkubicacionId) {
        return parkTarifaService
                .getAllParkTarifasByInstitucionIdAndUbicacion(institucionId, parkubicacionId);
    }
}

