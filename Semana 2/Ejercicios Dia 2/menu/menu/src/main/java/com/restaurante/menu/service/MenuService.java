package com.restaurante.menu.service;

import com.restaurante.menu.DTO.IngredienteDTO;
import com.restaurante.menu.DTO.PlatoDTO;
import com.restaurante.menu.model.Ingrediente;
import com.restaurante.menu.model.Plato;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {

    private final List<Plato> menu;
    private final List<Ingrediente> ingredientes;

    public MenuService(List<Plato> menu, List<Ingrediente> ingredientes) {
        this.menu = menu;
        this.ingredientes = ingredientes;
    }

    public PlatoDTO obtenerInformacionPlato(String nombre) {
        Plato plato = menu.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);

        if (plato != null) {
            double totalCalorias = plato.getListaIngredientes().stream()
                    .mapToDouble(this::calcularCaloriasIngrediente)
                    .sum();

            List<IngredienteDTO> ingredientesDTO = plato.getListaIngredientes().stream()
                    .map(this::mapIngredienteToDTO)
                    .collect(Collectors.toList());

            IngredienteDTO maxCalorias = ingredientesDTO.stream()
                    .max((i1, i2) -> Integer.compare(i1.getCantidadCalorias(), i2.getCantidadCalorias()))
                    .orElse(null);

            return new PlatoDTO(totalCalorias, ingredientesDTO, maxCalorias);
        }

        return null;
    }

    private double calcularCaloriasIngrediente(Long idIngrediente) {
        Ingrediente ingrediente = ingredientes.stream()
                .filter(i -> i.getIdIngrediente().equals(idIngrediente))
                .findFirst()
                .orElse(null);

        return (ingrediente != null) ? ingrediente.getCantidadCalorias() : 0;
    }

    private IngredienteDTO mapIngredienteToDTO(Long idIngrediente) {
        Ingrediente ingrediente = ingredientes.stream()
                .filter(i -> i.getIdIngrediente().equals(idIngrediente))
                .findFirst()
                .orElse(null);

        return (ingrediente != null) ? new IngredienteDTO(ingrediente.getNombre(), ingrediente.getCantidadCalorias()) : null;
    }
}