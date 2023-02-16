package com.example.demo.service;

import com.example.demo.model.Paciente;
import com.example.demo.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class PacienteService extends ServiceGeneric<Paciente> {

    @Autowired
    private PacienteRepository repository;

    public PacienteService(JpaRepository repository) {
        super(repository);
    }

}
