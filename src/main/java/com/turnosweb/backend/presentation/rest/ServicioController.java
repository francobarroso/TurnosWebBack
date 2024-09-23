package com.turnosweb.backend.presentation.rest;

import com.turnosweb.backend.business.services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/servicio")
@CrossOrigin("*")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.servicioService.getAll()
        );
    }
}
