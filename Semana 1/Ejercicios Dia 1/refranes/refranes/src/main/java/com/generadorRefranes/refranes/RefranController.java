package com.generadorRefranes.refranes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class RefranController {

    private final List<String> refranes = new ArrayList<>();

    public RefranController() {
        //Agregar refranes a la lista
        refranes.add("No hay mal que por bien no venga");
        refranes.add("Al que madruga Dios lo ayuda");
    }

    @GetMapping("/")
    public String obtenerRefranAleatorio() {
        //Obtiene un refrán aleatorio de la lista
        String refranAleatorio = obtenerRefranAleatorioDeLista();
        return "Refrán aleatorio: " + refranAleatorio;
    }

    private String obtenerRefranAleatorioDeLista() {
        //Generar índice aleatorio para obtener un refrán de la lista
        Random random = new Random();
        int indiceAleatorio = random.nextInt(refranes.size());
        return refranes.get(indiceAleatorio);
    }
}