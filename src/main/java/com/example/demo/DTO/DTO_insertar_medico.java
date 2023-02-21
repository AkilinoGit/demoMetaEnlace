package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class DTO_insertar_medico {

    @Getter
    @Setter
    @JsonProperty("nombre")
    private String nombre;
    @Getter
    @Setter
    @JsonProperty("apellidos")
    private String apellidos;
    @Getter
    @Setter
    @JsonProperty("usuario")
    private String usuario;
    @Getter
    @Setter
    @JsonProperty("clave")
    private String clave;
    @Getter
    @Setter
    @JsonProperty("numColegiado")
    private String numColegiado;
}
