package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Contribuyente;
import com.fernando9825.alcaldiasvrestapi.models.services.IContribuyenteService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(path = {"/api"})
public class ContribuyenteController {

    private final IContribuyenteService taxpayerService;

    @Autowired
    public ContribuyenteController(IContribuyenteService taxpayerService) {
        this.taxpayerService = taxpayerService;
    }

    @GetMapping(path = "/contribuyentes")
    public List<Contribuyente> getAllContribuyentes() {
        return taxpayerService.findAll();
    }

    // TODO: check this function
    @GetMapping(path = "/contribuyentes/{dui}")
    public ResponseEntity<?> getContribuyente(@PathVariable String dui) {
        Contribuyente contribuyente = taxpayerService.findById(dui);

        Map<String, Object> response = new HashMap<>();

        if (contribuyente == null) {
            response.put("informacion", "contribuyente no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("contribuyente", contribuyente);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
