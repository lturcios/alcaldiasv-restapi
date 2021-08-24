package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Financiamiento;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IFinanciamientoService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IRutaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class FinanciamientoController {

    private final IFinanciamientoService financiamientoService;
    private final IRutaService rutaService;

    public FinanciamientoController(IFinanciamientoService financiamientoService, IRutaService rutaService) {
        this.financiamientoService = financiamientoService;
        this.rutaService = rutaService;
    }

    @GetMapping(path = "financiamientos/{institucionId}/{usuarioEmail}")
    public ResponseEntity<?> findByInstitucionIdAndUsuarioEmail(@PathVariable short institucionId, @PathVariable String usuarioEmail){
        if(!rutaService.findAllByInstitucionIdAndUsuarioEmail(institucionId, usuarioEmail).isEmpty()) {
            List<Financiamiento> financiamientos = this.financiamientoService.findByInstitucionIdAndUsuarioEmail(institucionId, usuarioEmail);
            return (!financiamientos.isEmpty()) ? new ResponseEntity<>(financiamientos, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            List<Financiamiento> financiamientos = this.financiamientoService.findByInstitucionId(institucionId);
            return (!financiamientos.isEmpty()) ? new ResponseEntity<>(financiamientos, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
