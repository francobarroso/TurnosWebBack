package com.turnosweb.backend.business.services.Imp;

import com.turnosweb.backend.business.mapper.EmpleadoMapper;
import com.turnosweb.backend.business.services.EmpleadoService;
import com.turnosweb.backend.domain.dto.EmpleadoDto;
import com.turnosweb.backend.domain.entities.Empleado;
import com.turnosweb.backend.domain.entities.Horario;
import com.turnosweb.backend.domain.entities.Negocio;
import com.turnosweb.backend.repositories.EmpleadoRepository;
import com.turnosweb.backend.repositories.HorarioDetalleRepository;
import com.turnosweb.backend.repositories.NegocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EmpleadoServiceImp implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private NegocioRepository negocioRepository;

    @Autowired
    private HorarioDetalleRepository horarioDetalleRepository;

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

    @Override
    public Empleado update(Long id, Empleado empleado) {
        Empleado empleadoBd = this.empleadoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Empleado con id " + id + " no existe"));
        eliminarHorarios(empleadoBd, empleado);
        empleado.setNegocio(empleadoBd.getNegocio());
        return this.empleadoRepository.save(empleado);
    }

    public void eliminarHorarios(Empleado empleadoBd, Empleado empleado){
        List<Horario> horariosBd = empleadoBd.getHorarios();
        List<Horario> horariosReq = empleado.getHorarios();

        //Encontrar los horarios a eliminar
        for(Horario horarioBd : horariosBd) {
            if (horariosReq.stream().noneMatch(horarioReq -> horarioReq.getId() != null && horarioReq.getId().equals(horarioBd.getId()))) {
                horarioBd.getDias().clear();
                this.horarioDetalleRepository.deleteById(horarioBd.getId());
            }
        }
    }
}
