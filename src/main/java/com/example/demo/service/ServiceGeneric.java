package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public abstract class ServiceGeneric<T> {

    private JpaRepository<T,Long> repository;


    public ServiceGeneric (JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public List<T> findAll(){
        return repository.findAll();
    }

    public T findById(Long id){
        return (T) repository.findById(id);
    } //Dice UNSAFE

    public List<T> saveAll(List<T> entities){
        repository.saveAll(entities);
        return entities;
     }

    public T save(T elemento){
        repository.save(elemento); //SEGUN CrudRepository.class devuelve algo
        return  elemento;
    }
    public  void deleteById(Long id){
        repository.deleteById(id);
    }
}
