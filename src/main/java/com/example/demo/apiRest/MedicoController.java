package com.example.demo.apiRest;

import com.example.demo.model.Medico;
import com.example.demo.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class MedicoController {


    private MedicoService service ;


    //DEBERÍA DEVOLVER UN RESPONSE ENTITY?
    //Son un lío porque no se como entran y salen los datos

    @Autowired
    public MedicoController(MedicoService service){
        this.service=service;
    }

    @GetMapping("/medicos")
    public List<Medico> getMedicos(){
        return service.findAll();
    }

    @GetMapping("/medicos/{id}")
    public ResponseEntity<Medico> getMedicobyId(Long id) {
        Medico medico = service.findById(id);
        if (medico.getIdUsuario() == id)
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //HABRÍA QUE TRANSFORMAR DE JSON
    @PostMapping("medicos/new/")
    public ResponseEntity<Medico> crearUsuario(@RequestBody Medico nuevoMedico) {
        Medico usuarioCreado = service.save(nuevoMedico);
        return ResponseEntity.created(URI.create("/medicos/" + usuarioCreado.getIdUsuario())).body(usuarioCreado);
    }



}
