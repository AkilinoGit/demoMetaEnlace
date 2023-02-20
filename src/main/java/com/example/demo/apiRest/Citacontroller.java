package com.example.demo.apiRest;

import com.example.demo.model.Cita;
import com.example.demo.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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


    @GetMapping("/citas/{id}")
    public ResponseEntity<Cita> getCitabyId(Long id) {
        Cita cita = service.findById(id);
        if (cita.getIdCita() == id)
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @PostMapping("/citas/new/{id}")
    public ResponseEntity<Cita> crearUsuario(@RequestBody Cita nuevoCita) {
        Cita citaCreada = service.save(nuevoCita);
        return ResponseEntity.created(URI.create("/Citas/new/" + citaCreada.getIdCita())).body(citaCreada);
    }

    @PutMapping("/citas/update/{id}")
    public void actualizar(@PathVariable ("id") Long id, @RequestBody Cita Cita){
        service.deleteById(id);
        service.save(Cita);
    }
    @DeleteMapping("/citas/delete/{id}")
    void eliminarCita(@PathVariable Long id) {
        service.deleteById(id);
    }
}
