package com.concesionario.concesionario.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Vehicle {

    private Long id;
    private String brand;
    private String model;
    private Long kilometers;
    private Integer doors;
    private Double price;
}
