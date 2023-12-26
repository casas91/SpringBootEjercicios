package com.restaurante.menu.DTO;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurante.menu.model.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {
    private double totalCalorias;
    private List<IngredienteDTO> ingredientes;
    private IngredienteDTO maxCalorias;

    private List<PlatoDTO> loadDataBase() {
        File file = null;
        try {
            //aquí colocamos la url de nuestro archivo json que queremos cargar
            file = ResourceUtils.getFile("classpath:dishes.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PlatoDTO>> typeRef = new TypeReference<>() {};
        List<PlatoDTO> platDTO= null;
        try {
            platDTO= objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return platDTO;
    }

//para utilizar este código debes tener una clase IgredienteDTO creada o con el nombre que tu prefieras
//de igual manera si cargas el archivo de platos, deberás de tener el DTO correspondiente
}
