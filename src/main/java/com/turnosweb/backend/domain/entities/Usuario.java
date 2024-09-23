package com.turnosweb.backend.domain.entities;

import com.turnosweb.backend.domain.enums.Rol;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Usuario extends Base{
    private String username;
    private String password;
    private Rol rol;
}
