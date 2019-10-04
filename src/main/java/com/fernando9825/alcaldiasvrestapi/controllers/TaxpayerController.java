package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Taxpayer;
import com.fernando9825.alcaldiasvrestapi.models.services.ITaxpayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {"/api"})
public class TaxpayerController {

    private final ITaxpayerService taxpayerService;

    public TaxpayerController(ITaxpayerService taxpayerService){
        this.taxpayerService = taxpayerService;
    }

    @GetMapping(path = "/taxpayers")
    public List<Taxpayer> getAllTaxpayers(){
        return taxpayerService.findAll();
    }

}
