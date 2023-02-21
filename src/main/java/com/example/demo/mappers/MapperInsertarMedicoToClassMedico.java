package com.example.demo.mappers;

import com.example.demo.DTO.DTO_insertar_medico;
import com.example.demo.model.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MapperInsertarMedicoToClassMedico {
    Medico DTO_insertar_medicoToMedico(DTO_insertar_medico medico);
}
