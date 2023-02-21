package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Diagnostico {

    @Id
    @Column(name = "id_diagnostico", nullable = false)
    @GeneratedValue(generator="sequenciaIDDiagnosticos")
    @SequenceGenerator(name="sequenciaIDDiagnosticos",sequenceName="XE_SEQUENCIA_DIAGNOSTICOS", allocationSize=1)
    @Getter
    @Setter
    private Long id_Diagnostico;


    @Column(name = "valoracion_especialista")
    @Getter
    @Setter
    private String valoracionEspecialista;

    @Column(name = "enfermedad")
    @Getter
    @Setter
    private String enfermedad;

    @PrimaryKeyJoinColumn(name = "cita_id")
    @OneToOne(mappedBy = "diagnostico",cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Cita cita;


    public Diagnostico() {

    }


}
