package com.example.demo.apiRest;

import com.example.demo.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PacienteController {

    private PacienteService service;

    @Autowired
    public PacienteController(PacienteService service) {
        this.service = service;
    }
}
