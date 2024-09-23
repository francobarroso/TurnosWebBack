package com.turnosweb.backend.repositories;

import com.turnosweb.backend.domain.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
}
