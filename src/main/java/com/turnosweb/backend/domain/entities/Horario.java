package com.turnosweb.backend.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Horario extends Base{

    @OneToOne
    private Empleado empleado;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "horario_id")
    private Set<HorarioDetalles> detalles = new HashSet<>();

}
