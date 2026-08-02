package com.gonzalo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllItems_devuelve200() throws Exception {
        mockMvc.perform(get("/items"))
               .andExpect(status().isOk());
    }

    @Test
    void createItem_conDatosValidos_devuelve201() throws Exception {
        String itemJson = """
            {
                "name": "Teclado",
                "quantity": 5,
                "price": 25.0
            }
            """;

        mockMvc.perform(post("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(itemJson))
               .andExpect(status().isCreated());
    }


    @Test
    void createItem_conNombreVacio_devuelve400() throws Exception {
        String itemJson = """
            {
                "name": " "
            }
            """;

        mockMvc.perform(post("/items")
        .contentType(MediaType.APPLICATION_JSON)    
        .content(itemJson))
        .andExpect(status().isBadRequest());
    }
}
