package com.concesionario.concesionario.service;

import com.concesionario.concesionario.model.Vehicle;

import java.util.List;

public interface IVehicleService {
    public List<Vehicle> vehicleList();
    public Vehicle crearVehicle(Vehicle vehicle);
    public List<Vehicle>listaVehiclesIPorPrecio();
    public Vehicle VehicleById(Long id);
}