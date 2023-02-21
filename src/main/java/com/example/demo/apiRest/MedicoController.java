package com.example.demo.apiRest;

import com.example.demo.DTO.DTO_insertar_medico;
import com.example.demo.mappers.MapperInsertarMedicoToClassMedico;
import com.example.demo.model.Medico;
import com.example.demo.service.MedicoService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class MedicoController {


    private MedicoService service ;
    MapperInsertarMedicoToClassMedico mapper;




    //DEBERÍA DEVOLVER UN RESPONSE ENTITY?
    //Son un lío porque no se como entran y salen los datos

    @Autowired
    public MedicoController(MedicoService service){

        this.service=service;
        this.mapper = Mappers.getMapper(MapperInsertarMedicoToClassMedico.class);
    }

    @GetMapping("/medicos")
    public ResponseEntity<List<Medico>> getMedicos(){

        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/medicos/{id}")
    public ResponseEntity<Medico> getMedicobyId(Long id) {
        Medico medico = service.findById(id);
        if (medico.getIdUsuario() == id)
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("medicos/new")
    public ResponseEntity<Medico> crearUsuario(@RequestBody DTO_insertar_medico nuevoMedico) {

        Medico usuarioCreado = mapper.DTO_insertar_medicoToMedico(nuevoMedico);
                /*= new Medico(nuevoMedico.getNombre(), nuevoMedico.getApellidos(),
                nuevoMedico.getUsuario(),nuevoMedico.getClave(),nuevoMedico.getNumColegiado());*/

        //¿añadir id apartir de sequence o como?
        //Probar otra vez porque puede ser que oracle server no estuviera actualizado
        service.save(usuarioCreado);


        return ResponseEntity.created(URI.create("/medicos/new/" + usuarioCreado.getNombre())).body(usuarioCreado);
    }



}
