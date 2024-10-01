package com.turnosweb.backend.business.services;

import com.turnosweb.backend.domain.entities.Empleado;

import java.util.List;

public interface EmpleadoService {
    Empleado create(Empleado empleado);
    List<Empleado> getAll();
    Empleado update(Long id, Empleado empleado);
}
