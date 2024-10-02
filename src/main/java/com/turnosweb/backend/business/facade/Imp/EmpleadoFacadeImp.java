package com.turnosweb.backend.business.facade.Imp;

import com.turnosweb.backend.business.facade.EmpleadoFacade;
import com.turnosweb.backend.business.mapper.EmpleadoMapper;
import com.turnosweb.backend.business.services.EmpleadoService;
import com.turnosweb.backend.domain.dto.EmpleadoDto;
import com.turnosweb.backend.domain.dto.EmpleadoPostDto;
import com.turnosweb.backend.domain.entities.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoFacadeImp implements EmpleadoFacade {
    @Autowired
    private EmpleadoMapper empleadoMapper;
    @Autowired
    private EmpleadoService empleadoService;

    @Override
    public EmpleadoPostDto create(Empleado empleado) {
        return this.empleadoMapper.toDTO(this.empleadoService.create(empleado));
    }

    @Override
    public List<EmpleadoDto> getAll() {
        return this.empleadoMapper.toDTOsList(this.empleadoService.getAll());
    }

    @Override
    public EmpleadoPostDto update(Long id, Empleado empleado) {
        return this.empleadoMapper.toDTO(this.empleadoService.update(id, empleado));
    }
}
