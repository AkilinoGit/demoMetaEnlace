package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
public class Cita {
    @Id
    @Column(name = "id_cita", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //USAR SECUENCIA Y AÑADIR LA SECUENCIA
    @Getter
    @Setter
    private Long idCita;

    @Getter
    @Setter
    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;

    @Getter
    @Setter
    @Column(name = "motivo_cita")
    private String motivoCita;

    @Getter
    @Setter
    @Column(name = "atribute11")
    private int atribute11;

    @Getter
    @Setter
    @JoinColumn(name = "medico")
    @ManyToOne
    private Medico medico;

    @Getter
    @Setter
    @JoinColumn(name = "paciente")
    @ManyToOne
    private Paciente paciente;

    @Getter
    @Setter
    @PrimaryKeyJoinColumn(name = "diagnostico_id")
    @OneToOne
    private Diagnostico diagnostico;

    public Cita() {

    }


    public Cita(LocalDateTime fechaHora, String motivoCita, int atribute11, Medico medico, Paciente paciente, Diagnostico diagnostico) {
        this.fechaHora = fechaHora;
        this.motivoCita = motivoCita;
        this.atribute11 = atribute11;
        this.medico = medico;
        this.paciente = paciente;
        this.diagnostico = diagnostico;
    }



}
