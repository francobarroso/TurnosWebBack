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

    @OneToOne
    private Usuario usuario;
    
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private Set<Horario> horario;
}
