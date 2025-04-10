package com.usuarios.usuarios.service;

import com.usuarios.usuarios.Exception.UsuarioException;
import com.usuarios.usuarios.dto.ConfigDto;

public interface ConfigService {
    ConfigDto updatePattern(ConfigDto configDto) throws UsuarioException;
}
