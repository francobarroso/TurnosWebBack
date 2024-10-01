package com.turnosweb.backend.repositories;

import com.turnosweb.backend.domain.entities.Dia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaRepository extends JpaRepository<Dia, Long> {
}