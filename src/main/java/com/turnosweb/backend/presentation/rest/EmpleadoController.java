package com.turnosweb.backend.presentation.rest;

import com.turnosweb.backend.business.services.EmpleadoService;
import com.turnosweb.backend.domain.entities.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empleado")
@CrossOrigin("*")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;
    @GetMapping
    public ResponseEntity<?> getAll() {
        return null;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Empleado empleado) {
        return ResponseEntity.ok(this.empleadoService.create(empleado));
    }
}
