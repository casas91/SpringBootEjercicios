package com.restaurante.menu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {
    private Long idIngrediente;
    private String nombre;
    private int cantidadCalorias;
}
