package com.turnosweb.backend.business.facade;

import com.turnosweb.backend.domain.dto.EmpleadoDto;
import com.turnosweb.backend.domain.dto.EmpleadoPostDto;
import com.turnosweb.backend.domain.entities.Empleado;

import java.util.List;

public interface EmpleadoFacade {
    EmpleadoPostDto create(Empleado empleado);
    List<EmpleadoDto> getAll();
    EmpleadoPostDto update(Long id, Empleado empleado);
}
