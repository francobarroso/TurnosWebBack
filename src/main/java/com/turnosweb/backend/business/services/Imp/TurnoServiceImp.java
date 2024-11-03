package com.turnosweb.backend.business.services.Imp;

import com.turnosweb.backend.business.services.TurnoService;
import com.turnosweb.backend.domain.dto.TurnoDto;
import com.turnosweb.backend.domain.entities.Empleado;
import com.turnosweb.backend.domain.entities.Servicio;
import com.turnosweb.backend.domain.entities.Turno;
import com.turnosweb.backend.repositories.EmpleadoRepository;
import com.turnosweb.backend.repositories.ServicioRepository;
import com.turnosweb.backend.repositories.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TurnoServiceImp implements TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private ServicioRepository servicioRepository;
    @Override
    public List<Turno> getAll() {
        return this.turnoRepository.findAll();
    }

    @Override
    public Turno getById(Long id) {
        return this.turnoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro el turno con id: " + id));
    }

    @Override
    public Turno create(Turno request) {
        Empleado empleado = this.empleadoRepository.findById(request.getEmpleado().getId())
                .orElseThrow(() -> new RuntimeException("El empleado con id " + request.getEmpleado().getId() + " no existe"));
        request.setEmpleado(empleado);
        Servicio servicio = this.servicioRepository.findById(request.getServicio().getId())
                .orElseThrow(() -> new RuntimeException("El servicio con id " + request.getServicio().getId() + " no existe"));
        request.setServicio(servicio);

        return this.turnoRepository.save(request);
    }

    @Override
    public Turno update(Long id, TurnoDto request) {
        Turno turnoBd = this.turnoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Turno con id " + id + " no encontrado"));

        if(!turnoBd.isTerminado()) turnoBd.setTerminado(request.isTerminado());

        return this.turnoRepository.save(turnoBd);
    }

    @Override
    public List<Object> graph(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Turno> turnos = this.turnoRepository.findByFecha(fechaInicio, fechaFin);
        List<Object> turnosGraph = new ArrayList<>();

        // Formateadores para el mes y el día/mes
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM");
        DateTimeFormatter dayMonthFormatter = DateTimeFormatter.ofPattern("dd/MM");

        // Verificar si las fechas de inicio y fin están en el mismo mes
        boolean mismoMes = fechaInicio.getMonth().equals(fechaFin.getMonth()) && fechaInicio.getYear() == fechaFin.getYear();

        for (Turno turno : turnos) {
            Map<String, Object> turnoData = new HashMap<>();
            LocalDate fechaTurno = turno.getFechaTurno();
            double precioTurno = turno.getMonto();

            // Agregar el precio al map
            turnoData.put("precio", precioTurno);

            if (mismoMes) {
                // Si es el mismo mes, almacenar "día/mes" (dd/MM)
                String diaMes = fechaTurno.format(dayMonthFormatter);
                turnoData.put("fecha", diaMes);
            } else {
                // Si es diferente mes, almacenar el nombre del mes (MMMM)
                String nombreMes = fechaTurno.format(monthFormatter);
                turnoData.put("fecha", nombreMes);
            }

            turnosGraph.add(turnoData);
        }

        return turnosGraph;
    }
}
