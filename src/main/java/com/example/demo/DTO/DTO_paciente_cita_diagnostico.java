package com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class DTO_paciente_cita_diagnostico {

    @Getter
    @Setter
    private Long idPaciente;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private LocalDateTime fechaHora;
    @Getter
    @Setter
    private String enfermedad;
    @Getter
    @Setter
    private String valoracion;
}
