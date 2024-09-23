package com.turnosweb.backend.business.services.Imp;

import com.turnosweb.backend.business.services.ServicioService;
import com.turnosweb.backend.domain.entities.Servicio;
import com.turnosweb.backend.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioServiceImp implements ServicioService {
    @Autowired
    private ServicioRepository servicioRepository;
    @Override
    public String delete(Long id) {
        Servicio servicioBd = this.servicioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("El servicio id " + id + " no se encontro"));

        servicioBd.setEliminado(true);
        try {
            this.servicioRepository.save(servicioBd);
            return "Se elimino correctamente";
        }catch (Exception e){
            throw new RuntimeException("Error al eliminar el servicio con id " + id);
        }
    }

    @Override
    public List<Servicio> getAll() {
        return this.servicioRepository.findAll();
    }
}
