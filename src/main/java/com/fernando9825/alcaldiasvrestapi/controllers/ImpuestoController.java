package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Impuesto;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IImpuestoService;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IRutaService;
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
public class ImpuestoController {

    private final IImpuestoService impuestoService;

    private final IRutaService rutaService;

    @Autowired
    public ImpuestoController(IImpuestoService impuestoService, IRutaService rutaService) {
        this.impuestoService = impuestoService;
        this.rutaService = rutaService;
    }

    @GetMapping(path = "impuestos/{institucionId}/{usuarioEmail}")
    public ResponseEntity<?> findByInstitucionIdAndUsuarioEmail(
            @PathVariable short institucionId,
            @PathVariable String usuarioEmail){
        if(!rutaService.findAllByInstitucionIdAndUsuarioEmail(institucionId, usuarioEmail).isEmpty()){
            List<Impuesto> impuestos = this.impuestoService.findByInstitucionIdAndUsuarioEmail(institucionId, usuarioEmail);
            return (!impuestos.isEmpty()) ? new ResponseEntity<>(impuestos, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            List<Impuesto> impuestos = this.impuestoService.findByInstitucionId(institucionId);
            return (!impuestos.isEmpty()) ? new ResponseEntity<>(impuestos, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
