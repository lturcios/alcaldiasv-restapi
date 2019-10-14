package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Contribuyente;
import com.fernando9825.alcaldiasvrestapi.models.services.InstitucionInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class InstitucionController {

    private final InstitucionInterfaceService institucionService;

    @Autowired
    public InstitucionController(InstitucionInterfaceService institucionService){
        this.institucionService =  institucionService;
    }

    @GetMapping("/prueba")
    public List<Contribuyente> getContribuyentesByInstitucionId(Long institucionId){
        return this.getContribuyentesByInstitucionId(institucionId);
    }
}
