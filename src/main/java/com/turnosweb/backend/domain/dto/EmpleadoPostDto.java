package com.turnosweb.backend.domain.dto;

import com.turnosweb.backend.domain.entities.Horario;
import com.turnosweb.backend.domain.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpleadoPostDto {
    private String nombre;
    private String apellido;
    private Usuario usuario;
    private Set<Horario> horarios;
}
