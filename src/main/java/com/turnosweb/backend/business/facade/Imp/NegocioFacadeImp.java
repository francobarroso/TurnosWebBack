package com.turnosweb.backend.business.facade.Imp;

import com.turnosweb.backend.business.facade.NegocioFacade;
import com.turnosweb.backend.business.mapper.NegocioMapper;
import com.turnosweb.backend.business.services.NegocioService;
import com.turnosweb.backend.domain.dto.NegocioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NegocioFacadeImp implements NegocioFacade {
    @Autowired
    private NegocioService negocioService;
    @Autowired
    private NegocioMapper negocioMapper;

    @Override
    public List<NegocioDto> getAll() {
        return this.negocioMapper.toDTOsList(this.negocioService.getAll());
    }

    @Override
    public NegocioDto getById(Long id) {
        return this.negocioMapper.toDTO(this.negocioService.getById(id));
    }
}
