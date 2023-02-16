package com.example.demo.apiRest;

import com.example.demo.model.Medico;
import com.example.demo.repository.MedicoRepository;
import com.example.demo.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
public class MedicoController {

    @Autowired
    MedicoService service ;
    

    public MedicoController(MedicoService service){
        this.service=service;
    }
    @GetMapping("/medicos")
    public List<Medico> getMedicos(){
        return service.findAll();
    }
}
