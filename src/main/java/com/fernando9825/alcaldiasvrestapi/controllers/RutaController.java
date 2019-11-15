package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Ruta;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IRutaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Ruta> getAllRutasByInstitucionId(@PathVariable Long institucionId){
        return this.rutaService.findByInstitucionId(institucionId);
    }

    @GetMapping(path = "rutas/{institucionId}/{usuarioEmail}")
    public List<Ruta> getRutas(@PathVariable Long institucionId, @PathVariable String usuarioEmail) {
        return this.rutaService.findByInstitucionIdAndUsuarioEmail(institucionId, usuarioEmail);
    }
    
}
