package com.turnosweb.backend.business.mapper;

import com.turnosweb.backend.domain.dto.NegocioDto;
import com.turnosweb.backend.domain.entities.Negocio;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NegocioMapper {
    NegocioDto toDTO(Negocio source);
    List<NegocioDto> toDTOsList(List<Negocio> source);
}
