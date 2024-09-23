package com.turnosweb.backend.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
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
public class Servicio extends Base{
    private String denominacion;
    private Long precio;
}
