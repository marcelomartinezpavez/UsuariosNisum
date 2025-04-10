package com.usuarios.usuarios.service.impl;

import com.usuarios.usuarios.Exception.UsuarioException;
import com.usuarios.usuarios.dto.ConfigDto;
import com.usuarios.usuarios.repository.ConfigRepository;
import com.usuarios.usuarios.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    ConfigRepository configRepository;

    public ConfigDto updatePattern(ConfigDto configDto) throws UsuarioException {
        configDto.setId(1);
        return configRepository.save(configDto);
    }
}