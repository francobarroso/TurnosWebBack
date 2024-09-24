package com.turnosweb.backend.domain.dto;

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
public class NegocioDto extends BaseDto{
    private String denominacion;
    private String horario;
    private Set<ServicioDto> servicios = new HashSet<>();
}
