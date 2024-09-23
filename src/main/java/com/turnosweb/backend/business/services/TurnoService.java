package com.turnosweb.backend.business.services;

import com.turnosweb.backend.domain.entities.Turno;

import java.util.List;

public interface TurnoService {
    List<Turno> getAll();
    Turno getById(Long id);
    Turno create(Turno request);
    Turno update(Long id, Turno request);
}