package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.DiverTarifa;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IDiverTarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class DiverTarifaController {

    private final IDiverTarifaService diverTarifaService;

    @Autowired
    public DiverTarifaController(IDiverTarifaService diverTarifaService) {
        this.diverTarifaService = diverTarifaService;
    }

    @GetMapping(path = "divertarifas/{institucionId}")
    public List<DiverTarifa> getAllTarifasByInstitucionId(@PathVariable short institucionId){
        return this.diverTarifaService.getAllDiverTarifasByInstitucionId(institucionId);
    }

    @GetMapping(path = "divertarifas/{institucionId}/diverubicacionId")
    public List<DiverTarifa> getAllTarifasByInstitucionIdAndUbicacion(
            @PathVariable short institucionId,
            @PathVariable int diverubicacionId
    ){
        return this.diverTarifaService.getAllDiverTarifasByInstitucionIdAndUbicacion(institucionId, diverubicacionId);
    }
}
