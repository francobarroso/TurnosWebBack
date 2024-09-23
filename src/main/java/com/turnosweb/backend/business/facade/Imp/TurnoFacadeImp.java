package com.turnosweb.backend.business.facade.Imp;

import com.turnosweb.backend.business.facade.TurnoFacade;
import com.turnosweb.backend.business.mapper.TurnoMapper;
import com.turnosweb.backend.business.services.TurnoService;
import com.turnosweb.backend.domain.dto.TurnoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoFacadeImp implements TurnoFacade {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private TurnoMapper turnoMapper;
    @Override
    public List<TurnoDto> getAll() {
        return this.turnoMapper.toDTOsList(this.turnoService.getAll());
    }

    @Override
    public TurnoDto getById(Long id) {
        return this.turnoMapper.toDTO(this.turnoService.getById(id));
    }
}
