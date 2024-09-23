package com.turnosweb.backend.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Turno extends Base{
    private String fechaTurno;
    private String horaTurno;

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
