package com.turnosweb.backend.business.facade;

import com.turnosweb.backend.domain.dto.EmpleadoDto;
import com.turnosweb.backend.domain.entities.Empleado;

import java.util.List;

public interface EmpleadoFacade {
    EmpleadoDto create(Empleado empleado);
    List<EmpleadoDto> getAll();
    EmpleadoDto update(Long id, Empleado empleado);
}
