package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.TuriTarifa;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ITuriTarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class TuriTarifaController {

    private final ITuriTarifaService turiTarifaService;

    @Autowired
    public TuriTarifaController(ITuriTarifaService turiTarifaService) {
        this.turiTarifaService = turiTarifaService;
    }

    @GetMapping("turitarifas/{institucionId}/{ubicacion}")
    public List<TuriTarifa> getAllTuriTarifasByInstitucionIdAndUbicacion(
            @PathVariable short institucionId,
            @PathVariable int ubicacion
    ){
        return turiTarifaService.getAllTuriTarifasByInstitucionIdAndUbicacion(
                institucionId,
                ubicacion
        );
    }

}
