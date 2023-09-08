package br.com.springbootcrud.projectspringbootcrud.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.springbootcrud.projectspringbootcrud.IntegrationTest;
import br.com.springbootcrud.projectspringbootcrud.model.Usuario;
import br.com.springbootcrud.projectspringbootcrud.repositories.UsuarioRepository;

@IntegrationTest
public class UsuarioControllerIntegrationTest {
    
    @Autowired
    private MockMvc mvc;
    @Autowired
    private UsuarioRepository repository;

    @Test
    @DisplayName ("get all usuarios")
    void getAllUsuarios() throws Exception{
        Usuario joao = new Usuario( "João", 22);
        Usuario maria = new Usuario( "Maria", 25);

        repository.save(joao);
        repository.save(maria);

        mvc.perform(get("/listartodos"))
            .andExpect((status()).isOk())
            .andExpect(jsonPath("$.length()").value(2));
            


    }

    @Test
    @DisplayName ("salvar")
    void salvar() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        Usuario maria = new Usuario( "Maria", 55);

        mvc.perform(
            post("/salvar")
            .contentType(MediaType.APPLICATION_JSON)
            .contentType(objectMapper.writeValueAsString(maria)))

            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").isNotEmpty())
            .andExpect(jsonPath("$.nome").value("Maria"))
            .andExpect(jsonPath("$.idade").value(40));
    }

}
