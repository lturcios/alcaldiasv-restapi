package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Sanitarifa;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ISaniTarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class SaniTarifaController {

    private final ISaniTarifaService sanitarifaService;

    @Autowired
    public SaniTarifaController(ISaniTarifaService sanitarifaService) {
        this.sanitarifaService = sanitarifaService;
    }

    @GetMapping(path = "sanitarifas/{institucionId}")
    public List<Sanitarifa> getAllTarifasByInstitucionId(@PathVariable short institucionId){
        return this.sanitarifaService.getAllSaniTarifasByInstitucionId(institucionId);
    }

    @GetMapping(path = "sanitarifas/{institucionId}/{saniubicacionId}")
    public List<Sanitarifa> getAllSaniTarifasByInstitucionIdAndUbicacion(
            @PathVariable short institucionId,
            @PathVariable int saniubicacionId){
        return this.sanitarifaService.getAllSaniTarifasByInstitucionIdAndUbicacion(institucionId, saniubicacionId);
    }

}
