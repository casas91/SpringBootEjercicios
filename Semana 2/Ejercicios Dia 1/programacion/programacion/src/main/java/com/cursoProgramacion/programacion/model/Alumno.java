package com.cursoProgramacion.programacion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {
    private Long numMatricula;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
}
