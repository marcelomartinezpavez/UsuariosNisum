package com.usuarios.usuarios.controller;

import com.usuarios.usuarios.Exception.UsuarioException;
import com.usuarios.usuarios.request.UsuarioRequest;
import com.usuarios.usuarios.response.ErrorResponse;
import com.usuarios.usuarios.response.UsuarioResponse;
import com.usuarios.usuarios.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/usuario")
public class UsuarioController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UsuarioService usuarioService;

    @PostMapping(path = "/insert",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public @ResponseBody ResponseEntity createUser(@RequestBody UsuarioRequest usuarioDto) {
        try {
            UsuarioResponse resp = usuarioService.createUser(usuarioDto);
            return new ResponseEntity(resp, HttpStatus.OK);
        } catch (UsuarioException ue){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMensaje(ue.getMessage());
            errorResponse.setStatusCode(ue.getHttpStatusCode());

            return new ResponseEntity(errorResponse, HttpStatusCode.valueOf(ue.getHttpStatusCode()));
        } catch (Exception e){
            e.printStackTrace();
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMensaje("Error inesperado");
            errorResponse.setStatusCode(500);
            return new ResponseEntity(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
