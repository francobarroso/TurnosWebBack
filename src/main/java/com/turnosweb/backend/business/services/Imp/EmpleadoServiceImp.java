package com.turnosweb.backend.business.services.Imp;

import com.turnosweb.backend.business.services.EmpleadoService;
import com.turnosweb.backend.domain.entities.Empleado;
import com.turnosweb.backend.domain.entities.Negocio;
import com.turnosweb.backend.repositories.EmpleadoRepository;
import com.turnosweb.backend.repositories.NegocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImp implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private NegocioRepository negocioRepository;

    @Override
    public Empleado create(Empleado empleado) {
        Negocio negocio = this.negocioRepository.findById(empleado.getNegocio().getId())
                .orElseThrow(() -> new RuntimeException("El negocio con id " + empleado.getNegocio().getId() + " no existe"));
        empleado.setNegocio(negocio);
        return this.empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleado> getAll() {
        return this.empleadoRepository.findAll();
    }
}
