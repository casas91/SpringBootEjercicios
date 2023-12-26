package com.cursoProgramacion.programacion.service;
import com.cursoProgramacion.programacion.model.Alumno;
import com.cursoProgramacion.programacion.model.Calificacion;

import java.util.List;

public interface IEstudianteService {
    List<Alumno> obtenerTodosEstudiantes();
    List<Calificacion> obtenerCalificacionesPorMatricula(Long numMatricula);
    List<Calificacion> obtenerCalificacionesOrdenDesc();
}
