package com.turnosweb.backend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TurnoDto extends BaseDto{
    private String fechaTurno;
    private String horaTurno;
    private String nombre;
    private String apellido;
    private ServicioDto servicio;
}
