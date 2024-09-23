package com.turnosweb.backend.business.facade;

import com.turnosweb.backend.domain.dto.NegocioDto;

import java.util.List;

public interface NegocioFacade {
    List<NegocioDto> getAll();
    NegocioDto getById(Long id);
}
