package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
public class Medico extends Usuario{
    //¿Ya me mapea los atributos como elementos sin decirle el nombre de columna?: Mejor definir con barrabajas para oracle
    //Cuando es obligatorio definir los mapped?: mapped cuando no es el propietrario de la relación
    @Id
    @PrimaryKeyJoinColumn(name="idUsuario")
    @Column(name = "id_medico", nullable = false)
    @Getter @Setter
    private Long id_Medico;

    @Getter @Setter
    private String numColegiado;

    @ManyToMany
    @JoinTable(name = "medico_paciente",
    joinColumns = @JoinColumn(name = "id_medico"),
    inverseJoinColumns = @JoinColumn(name = "id_paciente"))
    @Getter @Setter
    private List<Paciente> pacientes;


    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL) //¿Política de cascada?: DEFINIR ANTES DE LEVANTAR SERVIDR SQL
    @Getter @Setter
    private List<Cita> citas;



    public Medico(String nombre, String apellidos, String usuario, String clave, Long id_Medico, String numColegiado,
                  List<Paciente> pacientes, List<Cita> citas) {
        super(nombre, apellidos, usuario, clave);
        this.id_Medico = id_Medico;
        this.numColegiado = numColegiado;
        this.pacientes = pacientes;
        this.citas = citas;
    }

    public Medico() {
        super();
    }



}
