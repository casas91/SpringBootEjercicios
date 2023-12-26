package com.concesionario.concesionario.service;

import com.concesionario.concesionario.model.Vehicle;
import com.concesionario.concesionario.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService{
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> vehicleList() {
        return vehicleRepository.vehicleList();
    }

    @Override
    public Vehicle crearVehicle(Vehicle vehicle) {
        vehicle.setId((long) (vehicleRepository.vehicleList().size()+1));
        vehicleRepository.vehicleList().add(vehicle);
        return vehicle;
    }

    @Override
    public List<Vehicle> listaVehiclesIPorPrecio() {
        return vehicleRepository.vehicleList().stream()
                .sorted(Comparator.comparing(Vehicle::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle VehicleById(Long id) {
        return vehicleRepository.vehicleList().stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst().orElse(null);
    }
}

