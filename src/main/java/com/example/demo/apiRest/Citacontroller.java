package com.example.demo.apiRest;

import com.example.demo.model.Cita;
import com.example.demo.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Citacontroller   {

    private CitaService service;

    @Autowired
    public Citacontroller(CitaService service){
        this.service=service;
    }

    @GetMapping("/citas")
    public List<Cita> getCitas(){
        return service.findAll();
    }
}
