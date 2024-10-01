package com.turnosweb.backend.domain.dto;

import com.turnosweb.backend.domain.entities.HorarioDetalles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HorarioDto {
    private Set<HorarioDetalles> detalles = new HashSet<>();
}
