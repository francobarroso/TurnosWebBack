package com.turnosweb.backend.business.facade.Imp;

import com.turnosweb.backend.business.facade.EmpleadoFacade;
import com.turnosweb.backend.business.mapper.EmpleadoMapper;
import com.turnosweb.backend.business.services.EmpleadoService;
import com.turnosweb.backend.domain.dto.EmpleadoDto;
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
    public List<EmpleadoDto> getAll() {
        return this.empleadoMapper.toDTOsList(this.empleadoService.getAll());
    }
}
