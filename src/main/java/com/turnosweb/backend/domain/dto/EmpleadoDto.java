package com.turnosweb.backend.domain.dto;

import com.turnosweb.backend.domain.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpleadoDto extends BaseDto{
    private String nombre;
    private String apellido;
    private Usuario usuario;
}
