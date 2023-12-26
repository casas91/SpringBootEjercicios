package com.restaurante.menu.controller;

import com.restaurante.menu.DTO.PlatoDTO;
import com.restaurante.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/{nombre}")
    public PlatoDTO obtenerInformacionPlato(@PathVariable String nombre) {
        return menuService.obtenerInformacionPlato(nombre);
    }
}