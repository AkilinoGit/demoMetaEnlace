package com.example.demo.apiRest;

import com.example.demo.model.Diagnostico;
import com.example.demo.service.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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



    @GetMapping("/diagnosticos/{id}")
    public ResponseEntity<Diagnostico> getdiagnosticobyId(Long id) {
        Diagnostico diagnostico = service.findById(id);
        if (diagnostico.getId_Diagnostico() == id)
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @PostMapping("/diagnosticos/new/{id}")
    public ResponseEntity<Diagnostico> crearUsuario(@RequestBody Diagnostico nuevoDiagnostico) {
        Diagnostico diagnosticoCreado = service.save(nuevoDiagnostico);
        return ResponseEntity.created(URI.create("/diagnosticos/new/" + diagnosticoCreado.getId_Diagnostico()))
                .body(diagnosticoCreado);
    }

    @PutMapping("/diagnosticos/update/{id}")
    public void actualizar(@PathVariable ("id") Long id, @RequestBody Diagnostico diagnostico){
        service.deleteById(id);
        service.save(diagnostico);
    }
    @DeleteMapping("/diagnosticos/delete/{id}")
    void eliminarDiagnostico(@PathVariable Long id) {
        service.deleteById(id);
    }
}
