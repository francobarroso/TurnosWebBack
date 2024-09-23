package com.turnosweb.backend.presentation.rest;

import com.turnosweb.backend.business.facade.NegocioFacade;
import com.turnosweb.backend.business.services.NegocioService;
import com.turnosweb.backend.domain.entities.Negocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/negocio")
@CrossOrigin("*")
public class NegocioController {
    @Autowired
    private NegocioFacade negocioFacade;
    @Autowired
    private NegocioService negocioService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.negocioFacade.getAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.negocioFacade.getById(id)
        );
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Negocio request){
        return ResponseEntity.ok(this.negocioService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Negocio request){
        return ResponseEntity.ok(this.negocioService.update(id ,request));
    }
}
