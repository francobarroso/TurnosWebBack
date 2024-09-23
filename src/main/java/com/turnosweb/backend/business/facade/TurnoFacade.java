package com.turnosweb.backend.business.facade;

import com.turnosweb.backend.domain.dto.TurnoDto;

import java.util.List;

public interface TurnoFacade {
    List<TurnoDto> getAll();
    TurnoDto getById(Long id);
}
