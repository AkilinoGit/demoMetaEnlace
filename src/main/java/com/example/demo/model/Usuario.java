package com.example.demo.model;

import jakarta.persistence.*;

// HERENCIA DE JPA TAMBÍEN
@MappedSuperclass
@PrimaryKeyJoinColumn(name = "id_usuario")
public abstract class Usuario {
    @Id
    @Column(name = "id_usuario", nullable = false)
    @GeneratedValue(generator="sequenciaIDUsuarios")
    @SequenceGenerator(name="sequenciaIDUsuarios",sequenceName="XE_SEQUENCIA_USUARIOS", allocationSize=1)
    private Long idUsuario;

    private String nombre;
    private String apellidos;
    private String usuario;
    private String clave;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }


    public Usuario(String nombre, String apellidos, String usuario, String clave) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.clave = clave;
    }

    public Usuario() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}

