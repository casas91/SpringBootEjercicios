package com.cursoProgramacion.programacion.controller;

import com.cursoProgramacion.programacion.model.Alumno;
import com.cursoProgramacion.programacion.model.Calificacion;
import com.cursoProgramacion.programacion.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    @Autowired
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public List<Alumno> obtenerListaAlumnos(){
        return estudianteService.obtenerTodosEstudiantes();
    }

    @GetMapping("/{numMatricula}")
    public List<Calificacion> obtenerCalificacionesPorMatricula(@PathVariable Long numMatricula) {
        return estudianteService.obtenerCalificacionesPorMatricula(numMatricula);
    }

    @GetMapping("/ordendesc")
    public List<Calificacion> obtenerCalificacionesOrdenDesc() {
        return estudianteService.obtenerCalificacionesOrdenDesc();
    }
}
