package com.cursoProgramacion.programacion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calificacion {
    private Long id;
    private int calificacion1;
    private int calificacion2;
    private int calificacion3;
    private double promedio;
    private Alumno alumno;
}