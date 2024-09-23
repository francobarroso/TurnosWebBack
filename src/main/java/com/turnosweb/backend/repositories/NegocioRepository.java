package com.turnosweb.backend.repositories;

import com.turnosweb.backend.domain.entities.Negocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NegocioRepository extends JpaRepository<Negocio, Long> {
}
