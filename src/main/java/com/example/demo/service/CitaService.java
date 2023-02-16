package com.example.demo.service;

import com.example.demo.model.Cita;
import com.example.demo.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class CitaService extends ServiceGeneric<Cita>{
    @Autowired
    private CitaRepository repository;

    public CitaService(JpaRepository<Cita, Long> repository) {
        super(repository);
    }
}
