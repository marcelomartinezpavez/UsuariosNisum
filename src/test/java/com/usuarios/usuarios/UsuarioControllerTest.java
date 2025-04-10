package com.usuarios.usuarios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usuarios.usuarios.Exception.UsuarioException;
import com.usuarios.usuarios.controller.UsuarioController;
import com.usuarios.usuarios.request.PhonesRequest;
import com.usuarios.usuarios.request.UsuarioRequest;
import com.usuarios.usuarios.response.UsuarioResponse;
import com.usuarios.usuarios.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UsuarioService usuarioService;

    @Test
    void createUserOK() throws Exception {
        UsuarioRequest usuarioRequest = new UsuarioRequest();
        usuarioRequest.setEmail("marcelomartinezpavez@gmail.com");
        usuarioRequest.setName("Marcelo");
        PhonesRequest phonesRequest = new PhonesRequest();
        phonesRequest.setCitycode("1");
        phonesRequest.setContrycode("57");
        phonesRequest.setNumber("958365746");
        List<PhonesRequest> phoneList = new ArrayList<PhonesRequest>();
        phoneList.add(phonesRequest);
        usuarioRequest.setPhones(phoneList);
        usuarioRequest.setPassword("123456");
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        when(usuarioService.createUser(usuarioRequest)).thenReturn(usuarioResponse);
        ObjectMapper objectMapper = new ObjectMapper();
        this.mockMvc.perform(post("/api/usuario/insert")
                .content(objectMapper.writeValueAsString(usuarioRequest))
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void createUserInvalidMail() throws Exception {
        UsuarioRequest usuarioRequest = new UsuarioRequest();
        usuarioRequest.setEmail("marcelomartinezpavez@");
        usuarioRequest.setName("Marcelo");
        PhonesRequest phonesRequest = new PhonesRequest();
        phonesRequest.setCitycode("1");
        phonesRequest.setContrycode("57");
        phonesRequest.setNumber("958365746");
        List<PhonesRequest> phoneList = new ArrayList<PhonesRequest>();
        phoneList.add(phonesRequest);
        usuarioRequest.setPhones(phoneList);
        usuarioRequest.setPassword("123456");
        UsuarioException usuarioException = new UsuarioException("email invalido", 400);
        doThrow(usuarioException).when(usuarioService).createUser(usuarioRequest);

        Exception exception = assertThrows(Exception.class, () -> {
            usuarioService.createUser(usuarioRequest);
        });
        assertEquals("mensaje: email invalido", exception.getMessage());
    }

}
