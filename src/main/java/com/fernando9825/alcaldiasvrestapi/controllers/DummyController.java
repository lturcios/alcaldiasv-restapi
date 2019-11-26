package com.fernando9825.alcaldiasvrestapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

    @RequestMapping(path = "/")
    public String wakaWake(){
        return "<h1>I'm awake ;)</h1>";
    }
}
