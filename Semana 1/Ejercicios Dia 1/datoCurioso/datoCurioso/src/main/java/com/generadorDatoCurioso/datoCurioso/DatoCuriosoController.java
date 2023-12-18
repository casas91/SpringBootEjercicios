package com.generadorDatoCurioso.datoCurioso;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@RestController
public class DatoCuriosoController {

        private final List<String> datoCurioso = new ArrayList<>();

        public DatoCuriosoController() {
            //Agregar datos a la lista
            datoCurioso.add("Los delfines tienen la capacidad de reconocer y recordar estos silbidos específicos incluso después de mucho tiempo");
            datoCurioso.add("Las hormigas son capaces de llevar objetos que son hasta 50 veces su propio peso");
            datoCurioso.add("La trompa de un elefante cuenta con alrededor de 40,000 músculos");
        }

        @GetMapping
        public String obtenerDatoCuriosoAleatorio() {
            String datoCuriosoAleatorio = obtenerDatoCuriosoAleatorioDeLista();
            return "Dato Curioso: " + datoCuriosoAleatorio;
        }

        private String obtenerDatoCuriosoAleatorioDeLista() {
            //Generar índice aleatorio para obtener un dato de la lista
            Random random = new Random();
            int indiceAleatorio = random.nextInt(datoCurioso.size());
            return datoCurioso.get(indiceAleatorio);
        }
    }

