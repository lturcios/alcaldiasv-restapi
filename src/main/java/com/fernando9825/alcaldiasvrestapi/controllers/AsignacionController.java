package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Asignacion;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IAsignacionService;
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
public class AsignacionController {

    private final IAsignacionService asignacionService;

    public AsignacionController(IAsignacionService asignacionService) {
        this.asignacionService = asignacionService;
    }

    @GetMapping(path = "asignaciones/{institucionId}")
    public ResponseEntity<?> findAllByInstitucionId(@PathVariable Long institucionId){

        try{
            List<Asignacion> asignaciones = this.asignacionService.findByInstitucionId(institucionId);
            return (!asignaciones.isEmpty()) ? new ResponseEntity<>(asignaciones, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            Map<String, Object> response = new HashMap<>();
            response.put("error", e.getCause());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

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
