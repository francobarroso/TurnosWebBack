package com.turnosweb.backend.presentation.rest;

import com.turnosweb.backend.repositories.DiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dia")
@CrossOrigin("*")
public class DiaController {
    @Autowired
    private DiaRepository diaRepository;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.diaRepository.findAll());
    }
}
