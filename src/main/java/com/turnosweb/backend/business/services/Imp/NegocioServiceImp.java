package com.turnosweb.backend.business.services.Imp;

import com.turnosweb.backend.business.services.NegocioService;
import com.turnosweb.backend.business.services.ServicioService;
import com.turnosweb.backend.domain.entities.Negocio;
import com.turnosweb.backend.domain.entities.Servicio;
import com.turnosweb.backend.repositories.NegocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class NegocioServiceImp implements NegocioService {

    @Autowired
    private NegocioRepository negocioRepository;

    @Autowired
    private ServicioService servicioService;
    @Override
    public List<Negocio> getAll() {
        return this.negocioRepository.findAll();
    }

    @Override
    public Negocio getById(Long id) {
        return this.negocioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("El negocio con id " + id + " no existe"));
    }

    @Override
    public Negocio create(Negocio request) {
        return this.negocioRepository.save(request);
    }

    @Override
    public Negocio update(Long id, Negocio request) {
        Negocio negocioBd = this.negocioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("El negocio con id " + id + " no existe"));

        negocioBd.setDenominacion(request.getDenominacion());
        negocioBd.setHorario(request.getHorario());
        negocioBd.setServicios(editarServicios(negocioBd,request));

        return this.negocioRepository.save(negocioBd);
    }

    public Set<Servicio> editarServicios(Negocio negocioBd, Negocio request) {
        Set<Servicio> serviciosBd = negocioBd.getServicios();
        Set<Servicio> serviciosReq = request.getServicios();
        Set<Servicio> serviciosDeleted = new HashSet<>(serviciosBd);

        //Añadir nuevamente un servicio
        for(Servicio servicioAdd : serviciosReq){
            if(servicioAdd.isEliminado()) servicioAdd.setEliminado(false);
        }

        //Eliminar servicios
        serviciosDeleted.removeAll(serviciosReq);
        if (!serviciosDeleted.isEmpty()) {
            for (Servicio servicioDeleted : serviciosDeleted) {
                this.servicioService.delete(servicioDeleted.getId());
            }
        }

        return serviciosReq;
    }
}
