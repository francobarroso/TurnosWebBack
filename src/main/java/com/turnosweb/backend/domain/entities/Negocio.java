package com.turnosweb.backend.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Negocio extends Base{
    private String denominacion;

    @Column(columnDefinition = "VARCHAR(500)")
    private String horario;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "negocio_id")
    @Builder.Default
    private Set<Servicio> servicios = new HashSet<>();
}
