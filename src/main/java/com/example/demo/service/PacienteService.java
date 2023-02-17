package com.example.demo.service;

import com.example.demo.model.Paciente;
import com.example.demo.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PacienteService extends ServiceGeneric<Paciente> {



    @Autowired
    public PacienteService(PacienteRepository repository) {
        super(repository);
    }

}
