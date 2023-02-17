package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Paciente extends Usuario{

    @Column(name = "nss")
    @Getter @Setter private String NSS;

    @Column(name = "num_tarjeta")
    @Getter @Setter private String numTarjeta;

    @Column(name = "telefono")
    @Getter @Setter private String telefono;

    @Column(name = "direccion")
    @Getter @Setter private String direccion;

    @ManyToMany(mappedBy = "pacientes")
    @Getter @Setter private List<Medico> medicos;



    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    @Getter @Setter private List<Cita> citas;

    public Paciente(String nombre, String apellidos, String usuario, String clave, String NSS,
                    String numTarjeta, String telefono, String direccion, List<Medico> medicos, List<Cita> citas) {
        super(nombre, apellidos, usuario, clave);
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
