package com.cursoProgramacion.programacion.service;

import com.cursoProgramacion.programacion.model.Alumno;
import com.cursoProgramacion.programacion.model.Calificacion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteService implements IEstudianteService {

    private static final List<Alumno> listaAlumnos = new ArrayList<>();
    private static final List<Calificacion> listaCalificaciones = new ArrayList<>();

    static {
        //Inicialización de la lista con algunos datos de ejemplo
        Alumno alumno1 = new Alumno(1L, "Juan", "Perez", "01-01-1990");
        Alumno alumno2 = new Alumno(2L, "Maria", "Gomez", "05-05-1992");

        listaAlumnos.add(alumno1);
        listaAlumnos.add(alumno2);

        //Simulación de calificaciones para la materia "Programación I"
        Calificacion calificacion1 = new Calificacion(1L, 90, 85, 78, calcularPromedio(90, 85, 78), alumno1);
        Calificacion calificacion2 = new Calificacion(2L, 75, 82, 88, calcularPromedio(75, 82, 88), alumno2);

        listaCalificaciones.add(calificacion1);
        listaCalificaciones.add(calificacion2);

    }

    @Override
    public List<Alumno> obtenerTodosEstudiantes() {
        return listaAlumnos;
    }

    @Override
    public List<Calificacion> obtenerCalificacionesPorMatricula(Long numMatricula) {
        List<Calificacion> calificacionesPorMatricula = new ArrayList<>();
        for (Calificacion calificacion : listaCalificaciones) {
            if (calificacion.getAlumno().getNumMatricula().equals(numMatricula)) {
                calificacionesPorMatricula.add(calificacion);
            }
        }
        return calificacionesPorMatricula;
    }

    @Override
    public List<Calificacion> obtenerCalificacionesOrdenDesc() {
        //Simplemente devolvemos la lista de calificaciones ordenadas de forma descendente
        listaCalificaciones.sort((c1, c2) -> Double.compare(c2.getPromedio(), c1.getPromedio()));
        return listaCalificaciones;
    }

    private static double calcularPromedio(int calificacion1, int calificacion2, int calificacion3) {
        return (calificacion1 + calificacion2 + calificacion3) / 3.0;
    }
}
