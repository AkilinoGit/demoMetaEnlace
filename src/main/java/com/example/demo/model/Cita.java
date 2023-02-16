package com.example.demo.model;

import jakarta.persistence.*;

import java.sql.Date;
@Entity
public class Cita {
    @Id
    @Column(name = "id_cita", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCita;

    @Column(name = "fecha_hora")//Para oracle
    private Date fechaHora; //Java.util o Java.sql??

    @Column(name = "motivoCita")
    private String motivoCita;

    @Column(name = "atribute11")
    private int atribute11;

    @Column(name = "medico")
    @ManyToOne
    private Medico medico;

    @Column(name = "paciente")
    @ManyToOne
    private Paciente paciente;

    @Column(name = "diagnostico")
    @OneToOne(mappedBy = "cita")
    private Diagnostico diagnostico;

    public Cita() {

    }

    public Long getIdCita() {
        return idCita;
    }

    public void setIdCita(Long idCita) {
        this.idCita = idCita;
    }

    public Cita(Date fechaHora, String motivoCita, int atribute11, Medico medico, Paciente paciente, Diagnostico diagnostico) {
        this.fechaHora = fechaHora;
        this.motivoCita = motivoCita;
        this.atribute11 = atribute11;
        this.medico = medico;
        this.paciente = paciente;
        this.diagnostico = diagnostico;
    }


    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public int getAtribute11() {
        return atribute11;
    }

    public void setAtribute11(int atribute11) {
        this.atribute11 = atribute11;
    }
}
