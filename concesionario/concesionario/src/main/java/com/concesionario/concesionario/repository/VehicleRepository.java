package com.concesionario.concesionario.repository;

import com.concesionario.concesionario.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {

    List<Vehicle> vehicleList = new ArrayList<>();

    public List<Vehicle>vehicleList(){
        return vehicleList;
    }

}