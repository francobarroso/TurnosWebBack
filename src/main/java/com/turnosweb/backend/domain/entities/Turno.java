package com.turnosweb.backend.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Turno extends Base{
    private LocalDate fechaTurno;
    private LocalTime horaTurno;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    private String nombre;
    private String apellido;
    private String email;
    private Integer monto;
    private boolean terminado;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;
}
