package com.example.demo.apiRest;

import com.example.demo.model.Diagnostico;
import com.example.demo.service.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiagnosticoController {
    private DiagnosticoService service;

    @Autowired
    public DiagnosticoController(DiagnosticoService service) {this.service = service;
    }

    @GetMapping("/diagnosticos")
    public List<Diagnostico> getDiagnosticos(){
        return service.findAll();
    }

}
