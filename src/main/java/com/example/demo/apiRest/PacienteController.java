package com.example.demo.apiRest;

import com.example.demo.model.Paciente;
import com.example.demo.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class PacienteController {

    private PacienteService service;

    @Autowired
    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping("/pacientes")
    public List<Paciente> getPacientes(){
        return service.findAll();
    }

    @GetMapping("/pacientes/{id}")
    public ResponseEntity<Paciente> getPacientebyId(Long id) {
        Paciente Paciente = service.findById(id);
        if (Paciente.getIdUsuario() == id)
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @PostMapping("/pacientes/new/{id}")
    public ResponseEntity<Paciente> crearUsuario(@RequestBody Paciente nuevoPaciente) {
        Paciente usuarioCreado = service.save(nuevoPaciente);
        return ResponseEntity.created(URI.create("/pacientes/new/" + usuarioCreado.getIdUsuario())).body(usuarioCreado);
    }

    @PutMapping("/pacientes/update/{id}")
    public void actualizar(@PathVariable ("id") Long id, @RequestBody Paciente Paciente){
        service.deleteById(id);
        service.save(Paciente);
    }
    @DeleteMapping("/pacientes/delete/{id}")
    void eliminarPaciente(@PathVariable Long id) {
        service.deleteById(id);
    }



}
