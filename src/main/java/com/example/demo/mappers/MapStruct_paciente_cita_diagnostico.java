package com.example.demo.mappers;

import com.example.demo.DTO.DTO_paciente_cita_diagnostico;
import com.example.demo.model.Cita;
import com.example.demo.model.Diagnostico;
import com.example.demo.model.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface MapStruct_paciente_cita_diagnostico {

    //SE PODRIA OPTIMIZAR METIENDO DIRECTAMENTE LOS VALORES EN VEZ DE LOS OBJETOS, ASI A LA HORA DE HACER
    // LA CONSULTA AL API REST NO TRAEMOS TANTA INFORMACIÓN IRRELEVANTE

    @Mappings({@Mapping(source = "paciente.idUsuario", target = "idPaciente"),
            @Mapping(source = "paciente.nombre", target = "nombre"),
            @Mapping(source = "cita.fechaHora", target = "fechaHora"),
            @Mapping(source = "diagnostico.enfermedad", target = "enfermedad"),
            @Mapping(source = "diagnostico.valoracionEspecialista", target = "valoracion"),})
    DTO_paciente_cita_diagnostico toPacienteCitaDiagnostico(Paciente paciente, Cita cita, Diagnostico diagnostico);
}
