package com.example.demo.service;

import com.example.demo.model.Cita;
import com.example.demo.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CitaService extends ServiceGeneric<Cita>{


    @Autowired
    public CitaService(JpaRepository<Cita, Long> repository) {
        super(repository);
    }
}
