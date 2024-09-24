package com.turnosweb.backend.business.mapper;

import com.turnosweb.backend.domain.dto.EmpleadoDto;
import com.turnosweb.backend.domain.entities.Empleado;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {
    EmpleadoDto toDTO(Empleado source);
    List<EmpleadoDto> toDTOsList(List<Empleado> source);
}
