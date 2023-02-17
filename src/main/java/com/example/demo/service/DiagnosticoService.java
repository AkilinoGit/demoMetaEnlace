package com.example.demo.service;

import com.example.demo.model.Diagnostico;
import com.example.demo.repository.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticoService extends ServiceGeneric<Diagnostico>{


    @Autowired
    public DiagnosticoService(JpaRepository<Diagnostico, Long> repository) {
        super(repository);
    }
}
