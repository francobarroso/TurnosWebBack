package com.turnosweb.backend.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Horario extends Base{
    private LocalTime horaInicio;
    private LocalTime horaFin;

    @ManyToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Dia> dias = new HashSet<>();
}
