package com.codigomorse.codigomorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigoMorseController {
    private final Map<Character, String> morseCodeMap = new HashMap<>();

    public CodigoMorseController() {
        // Inicializar el mapa de código Morse
        morseCodeMap.put('A', ".-");
        morseCodeMap.put('B', "-...");
        morseCodeMap.put('C', "-.-.");
        morseCodeMap.put('D', "-..");
        morseCodeMap.put('E', ".");
        morseCodeMap.put('F', "..-.");
        morseCodeMap.put('G', "--.");
        morseCodeMap.put('H', "....");
        morseCodeMap.put('I', "..");
        morseCodeMap.put('J', ".---");
        morseCodeMap.put('K', "-.-");
        morseCodeMap.put('L', ".-..");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('N', "-.");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('P', ".--.");
        morseCodeMap.put('Q', "--.-");
        morseCodeMap.put('R', ".-.");
        morseCodeMap.put('S', "...");
        morseCodeMap.put('T', "-");
        morseCodeMap.put('U', "..-");
        morseCodeMap.put('V', "...-");
        morseCodeMap.put('W', ".--");
        morseCodeMap.put('X', "-..-");
        morseCodeMap.put('Y', "-.--");
        morseCodeMap.put('Z', "--..");
        morseCodeMap.put('1', "· - - - -");
        morseCodeMap.put('2', "· · - - -");
        morseCodeMap.put('3', "· · · - -");
        morseCodeMap.put('4', "· · · · -");
        morseCodeMap.put('5', "· · · · ·");
        morseCodeMap.put('6', "- · · · ·");
        morseCodeMap.put('7', "- - · · ·");
        morseCodeMap.put('8', "- - - · ·");
        morseCodeMap.put('9', "- - - - ·");
        morseCodeMap.put('0', "- - - - -");

    }

    @GetMapping("/{palabra}")
    public String descifrarMorse(@PathVariable String palabra) {
        StringBuilder codigoMorse = new StringBuilder();

        for (char letra : palabra.toUpperCase().toCharArray()) {
            String codigo = morseCodeMap.get(letra);
            if (codigo != null) {
                codigoMorse.append(codigo).append(" ");
            }
        }

        String mensaje = String.format("El código morse para la palabra: %s es: \"%s\"",
                palabra.toUpperCase(), codigoMorse.toString().trim());

        return mensaje;
    }
}

