package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Asignacion;
import com.fernando9825.alcaldiasvrestapi.models.entity.Contribuyente;
import com.fernando9825.alcaldiasvrestapi.models.services.IAsignacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/")
public class AsignacionController {

    private final IAsignacionService asignacionService;

    public AsignacionController(IAsignacionService asignacionService) {
        this.asignacionService = asignacionService;
    }

    @GetMapping(path = "asignaciones/{institucionId}/{puestoId}")
    public Asignacion getAsignaciones(@PathVariable Long institucionId, @PathVariable Long puestoId){
        return this.asignacionService.findByInstitucionIdAndPuestoId(institucionId, puestoId);
    }

    /*@PutMapping(path = "asignaciones/{asignacionId}")
    public ResponseEntity<?> updateAsignacion(@Valid @RequestBody Asignacion updatedAsignacion,
                                              @PathVariable Long asignacionId, BindingResult result){
        if (result.hasErrors())
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);

        Asignacion asignacion = this.asignacionService.findById(asignacionId);

        if (asignacion == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        asignacion.setObservaciones();
    }*/
}
