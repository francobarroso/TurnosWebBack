package com.turnosweb.backend.domain.dto;

import java.util.HashSet;
import java.util.Set;

public class NegocioDto extends BaseDto{
    private String denominacion;
    private String horario;
    private Set<ServicioDto> servicios = new HashSet<>();
}
