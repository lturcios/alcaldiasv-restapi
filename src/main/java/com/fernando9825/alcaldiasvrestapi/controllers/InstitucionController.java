package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.InstitucionInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/")
public class InstitucionController {

    private final InstitucionInterfaceService institucionService;

    @Autowired
    public InstitucionController(InstitucionInterfaceService institucionService){
        this.institucionService =  institucionService;
    }

//    @GetMapping("prueba")
//    public List<Contribuyente> getContribuyentesByInstitucionId(Long institucionId){
//        return this.getContribuyentesByInstitucionId(institucionId);
//    }

    @GetMapping(path = "file/{institucionId}")
    public ResponseEntity<byte[]> getLogo(@PathVariable short institucionId){
        Institucion institucion = institucionService.findById(institucionId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"logo.png\"")
                .body(institucion.getImagen());
    }
}
