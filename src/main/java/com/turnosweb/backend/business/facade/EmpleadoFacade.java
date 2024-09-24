package com.turnosweb.backend.business.facade;

import com.turnosweb.backend.domain.dto.EmpleadoDto;

import java.util.List;

public interface EmpleadoFacade {
    List<EmpleadoDto> getAll();
}
