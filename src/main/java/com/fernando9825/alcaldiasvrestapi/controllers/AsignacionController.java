package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Asignacion;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IAsignacionService;
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
public class AsignacionController {

    private final IAsignacionService asignacionService;
    private final IRutaService rutaService;

    public AsignacionController(IAsignacionService asignacionService, IRutaService rutaService) {
        this.asignacionService = asignacionService;
        this.rutaService = rutaService;
    }

    @GetMapping(path = "asignaciones/{institucionId}")
    public ResponseEntity<?> findAllByInstitucionId(@PathVariable short institucionId) {

        List<Asignacion> asignaciones = this.asignacionService.findByInstitucionId(institucionId);
        return (!asignaciones.isEmpty()) ? new ResponseEntity<>(asignaciones, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "asignaciones/{institucionId}/{usuarioEmail}")
    public ResponseEntity<?> findByInstitucionIdAndUsuarioEmail(@PathVariable short institucionId, @PathVariable String usuarioEmail) {
        if(!rutaService.findAllByInstitucionIdAndUsuarioEmail(institucionId, usuarioEmail).isEmpty()) {
            List<Asignacion> asignaciones = this.asignacionService.findByInstitucionIdAndUsuarioEmail(institucionId, usuarioEmail);
            return (!asignaciones.isEmpty()) ? new ResponseEntity<>(asignaciones, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            List<Asignacion> asignaciones = this.asignacionService.findByInstitucionId(institucionId);
            return (!asignaciones.isEmpty()) ? new ResponseEntity<>(asignaciones, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
