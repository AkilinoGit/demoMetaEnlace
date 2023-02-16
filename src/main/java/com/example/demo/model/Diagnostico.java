package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Diagnostico {

    @Id
    @Column(name = "id_diagnostico", nullable = false)
    private Long id_Diagnostico;

    private String valoracionEspecialista;

    private String enfermedad;

    @OneToOne(mappedBy = "diagnostico")
    private Cita cita;


    public Diagnostico() {

    }

    public Long getId_Diagnostico() {
        return id_Diagnostico;
    }

    public void setId_Diagnostico(Long id_Diagnostico) {
        this.id_Diagnostico = id_Diagnostico;
    }
}
