package com.turnosweb.backend.domain.entities;

import com.turnosweb.backend.domain.enums.Dia;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Horario extends Base{
    private Dia diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

}
