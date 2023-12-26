package com.restaurante.menu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plato {
    private Long idPlato;
    private String nombre;
    private List<Long> listaIngredientes;
}
