package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Contribuyente;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IContribuyenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    // CRUD

    // create
    @PostMapping(path = "/contribuyentes")
    public ResponseEntity<?> create(@Valid @RequestBody Contribuyente contribuyente, BindingResult result){
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()){
        	for(ObjectError error : result.getFieldErrors()) {
        		response.put(error.getCode(), error.getDefaultMessage());
        	}
            response.put("error", response);
            
            
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.taxpayerService.save(contribuyente), HttpStatus.CREATED);
    }


    // read mappings
    @GetMapping(path = "/contribuyentes")
    public List<Contribuyente> getAllContribuyentes() {
        return taxpayerService.findAll();
    }

    // TODO: check this function
    @GetMapping(path = "/contribuyentes/{institucionId}")
    public List<Contribuyente> getContribuyente(@PathVariable short institucionId) {
        return this.taxpayerService.findByInstitucionId(institucionId);
    }

    // update
    @PutMapping(path = "/contribuyentes/{contribuyenteId}")
    public ResponseEntity<?> updateContribuyente(
            @Valid @RequestBody Contribuyente updatedContribuyente,
            @PathVariable int contribuyenteId, BindingResult result){
        if (result.hasErrors())
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);

        Contribuyente contribuyente = this.taxpayerService.findById(contribuyenteId);

        if (contribuyente == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        // updating values
        contribuyente.setCodigoCuenta(updatedContribuyente.getCodigoCuenta());
        contribuyente.setNombres(updatedContribuyente.getNombres());
        contribuyente.setApellidos(updatedContribuyente.getApellidos());
        contribuyente.setDUI(updatedContribuyente.getDUI());
        contribuyente.setTelefonoPrincipal(updatedContribuyente.getTelefonoPrincipal());
        contribuyente.setTelefonoSecundario(updatedContribuyente.getTelefonoSecundario());
        contribuyente.setNIT(updatedContribuyente.getNIT());
        contribuyente.setDireccion(updatedContribuyente.getDireccion());
        //contribuyente.setMunicipio(updatedContribuyente.getMunicipio());


        this.taxpayerService.save(contribuyente);
        return new ResponseEntity<>(contribuyente, HttpStatus.CREATED);

    }

    // delete
    @DeleteMapping(path = "/contribuentes/{contribuyenteId}")
    public void deleteByContribuyenteId(@PathVariable int contribuyenteId){
        this.taxpayerService.delete(contribuyenteId);
    }

}
