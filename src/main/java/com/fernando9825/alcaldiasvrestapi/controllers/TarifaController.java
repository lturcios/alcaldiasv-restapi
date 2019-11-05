package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Tarifa;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ITarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class TarifaController {

    private final ITarifaService tarifaService;

    @Autowired
    public TarifaController(ITarifaService tarifaService) {
        this.tarifaService = tarifaService;
    }

    @GetMapping(path = "tarifas/{institucionId}")
    public List<Tarifa> getAllTarifasByInstitucionId(@PathVariable Long institucionId){
        return this.tarifaService.getAllTarifasByInstitucion(institucionId);
    }
}
