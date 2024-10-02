package com.turnosweb.backend.presentation.rest;

import com.turnosweb.backend.business.facade.TurnoFacade;
import com.turnosweb.backend.business.services.TurnoService;
import com.turnosweb.backend.domain.dto.TurnoDto;
import com.turnosweb.backend.domain.entities.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/turno")
@CrossOrigin("*")
public class TurnoController {

    @Autowired
    private TurnoFacade turnoFacade;
    @Autowired
    private TurnoService turnoService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.turnoFacade.getAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.turnoFacade.getById(id)
        );
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Turno request){
        return ResponseEntity.ok(this.turnoService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody TurnoDto request){
        return ResponseEntity.ok(this.turnoService.update(id, request));
    }
}
