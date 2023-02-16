package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
public class Paciente extends Usuario{

    @Id
    @Column(name = "id_paciente", nullable = false)
    @PrimaryKeyJoinColumn(name="idUsuario")
    @Getter @Setter private Long id_Paciente;

    @Getter @Setter private String NSS;

    @Getter @Setter private String numTarjeta;

    @Getter @Setter private String telefono;

    @Getter @Setter private String direccion;

    @ManyToMany(mappedBy = "pacientes")
    @Getter @Setter private List<Medico> medicos;



    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    @Getter @Setter private List<Cita> citas;

    public Paciente(String nombre, String apellidos, String usuario, String clave, Long id_Paciente, String NSS,
                    String numTarjeta, String telefono, String direccion, List<Medico> medicos, List<Cita> citas) {
        super(nombre, apellidos, usuario, clave);
        this.id_Paciente = id_Paciente;
        this.NSS = NSS;
        this.numTarjeta = numTarjeta;
        this.telefono = telefono;
        this.direccion = direccion;
        this.medicos = medicos;
        this.citas = citas;
    }

    public Paciente() {

    }



}
