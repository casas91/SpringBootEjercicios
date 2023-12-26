package com.concesionario.concesionario.controller;

import com.concesionario.concesionario.model.Vehicle;
import com.concesionario.concesionario.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private IVehicleService vehicleService;

    @PostMapping
    public Vehicle crearVehicle(@RequestBody Vehicle vehicle){
        vehicleService.crearVehicle(vehicle);
        return vehicle;
    }

    @GetMapping
    public List<Vehicle> vehicleList(){
        return vehicleService.vehicleList();
    }
    @GetMapping("/prices")
    public List<Vehicle> listaVehiclesIPorPrecio(){
        return vehicleService.listaVehiclesIPorPrecio();
    }

    @GetMapping("/{id}")
    public Vehicle VehicleById(@PathVariable Long id){
        return vehicleService.VehicleById(id);
    }
}
