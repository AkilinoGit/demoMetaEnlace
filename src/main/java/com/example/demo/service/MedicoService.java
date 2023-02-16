package com.example.demo.service;

import com.example.demo.model.Medico;
import com.example.demo.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicoService extends ServiceGeneric<Medico> {
    //No hace falta añadir un repositorio porque realmente vamos a usar el repositorio de la calse abstracta
    /*
     public List<T> saveAll(List<T> entities){
        repository.saveAll(entities);
        return entities;
     }
     */

    @Autowired
    public MedicoService(JpaRepository<Medico, Long> repository) {
        super(repository);
    }
}
