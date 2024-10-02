package com.turnosweb.backend.repositories;

import com.turnosweb.backend.domain.entities.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioDetalleRepository extends JpaRepository<Horario,Long> {
}
