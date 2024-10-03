package com.turnosweb.backend.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Negocio extends Base{
    private String nombre;

    @Column(columnDefinition = "VARCHAR(500)")
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "negocio_id")
    @Builder.Default
    private List<Servicio> servicios = new ArrayList<>();
}
