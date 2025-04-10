package com.usuarios.usuarios.controller;

import com.usuarios.usuarios.dto.ConfigDto;
import com.usuarios.usuarios.response.ErrorResponse;
import com.usuarios.usuarios.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/config")
public class ConfigController {

    @Autowired
    ConfigService configService;

    @PutMapping(path = "/update/pattern",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public @ResponseBody ResponseEntity updatePattern(@RequestBody ConfigDto configDto) {
        try {
            ConfigDto resp = configService.updatePattern(configDto);
            return new ResponseEntity(resp, HttpStatus.OK);
        } catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMensaje(e.getMessage());
            return new ResponseEntity("Error al actualizar pattern",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
