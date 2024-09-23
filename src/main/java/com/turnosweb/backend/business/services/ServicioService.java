package com.turnosweb.backend.business.services;

import com.turnosweb.backend.domain.entities.Servicio;

import java.util.List;

public interface ServicioService {
    String delete(Long id);
    List<Servicio> getAll();
}
