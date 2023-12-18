package com.conversion.conversion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversionController {

    @GetMapping("/{centimetros}")
    public String convertirACentimetros(@PathVariable double centimetros) {
        double metros = centimetros / 100;  // Convertir centímetros a metros
        String message = String.format("El equivalente a " + centimetros +" es de: " +metros +" metros");

        return message;
    }
}
