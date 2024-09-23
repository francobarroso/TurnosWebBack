package com.turnosweb.backend.business.mapper;

import com.turnosweb.backend.domain.dto.TurnoDto;
import com.turnosweb.backend.domain.entities.Turno;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface TurnoMapper {
    TurnoDto toDTO(Turno source);
    List<TurnoDto> toDTOsList(List<Turno> source);
}
