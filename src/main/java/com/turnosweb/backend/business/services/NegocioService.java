package com.turnosweb.backend.business.services;

import com.turnosweb.backend.domain.entities.Negocio;

import java.util.List;

public interface NegocioService {
    List<Negocio> getAll();
    Negocio getById(Long id);
    Negocio create(Negocio request);
    Negocio update(Long id, Negocio request);
}
