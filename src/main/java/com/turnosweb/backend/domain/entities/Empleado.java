package com.turnosweb.backend.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Empleado extends Base {
    private String nombre;
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "negocio_id")
    private Negocio negocio;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;
    
    @OneToOne(mappedBy = "empleado", cascade = CascadeType.ALL)
    @JoinColumn(name = "empleado_id")
    private Horario horario;
}
