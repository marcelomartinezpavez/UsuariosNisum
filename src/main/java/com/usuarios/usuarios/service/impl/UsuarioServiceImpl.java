package com.usuarios.usuarios.service.impl;

import com.usuarios.usuarios.Exception.UsuarioException;
import com.usuarios.usuarios.dto.ConfigDto;
import com.usuarios.usuarios.dto.PhoneDto;
import com.usuarios.usuarios.dto.UsuarioDto;
import com.usuarios.usuarios.repository.ConfigRepository;
import com.usuarios.usuarios.repository.UsuariosRepository;
import com.usuarios.usuarios.request.UsuarioRequest;
import com.usuarios.usuarios.response.UsuarioResponse;
import com.usuarios.usuarios.security.services.JwtService;
import com.usuarios.usuarios.service.UsuarioService;
import com.usuarios.usuarios.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuariosRepository usuariosRepository;

    @Autowired
    ConfigRepository configRepository;

    @Autowired
    JwtService jwtService;

    public UsuarioResponse createUser(UsuarioRequest usuarioRequest) throws UsuarioException {
        UsuarioDto newUser = new UsuarioDto();
        Optional<ConfigDto> patternList = configRepository.findById(Long.valueOf(1));
        if(!patternList.isPresent()) {
                throw new UsuarioException("No existe una configuracion para validar email", 400);
            }
            if (!Util.validaEmail(usuarioRequest.getEmail(), patternList.get().getPattern())) {
                throw new UsuarioException("email invalido", 400);
            }

        newUser.setCreated(Date.valueOf(LocalDate.now()));
        newUser.setEmail(usuarioRequest.getEmail());
        newUser.setName(usuarioRequest.getName());
        newUser.setPassword(usuarioRequest.getPassword());
        newUser.setIsactive(true);
        newUser.setModified(Date.valueOf(LocalDate.now()));
        String token = jwtService.getJWTToken(usuarioRequest.getEmail(), usuarioRequest.getPassword());
        newUser.setToken(token);

        List<PhoneDto> phonesList = new ArrayList<PhoneDto>();
        usuarioRequest.getPhones().forEach(phonesRequest -> {
            PhoneDto phoneDto = new PhoneDto();
            phoneDto.setCitycode(phonesRequest.getCitycode());
            phoneDto.setContrycode(phonesRequest.getContrycode());
            phoneDto.setNumber(phonesRequest.getNumber());
            phonesList.add(phoneDto);
        });
        newUser.setPhones(phonesList);

        UsuarioDto newUserDto = usuariosRepository.save(newUser);
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setId(newUserDto.getId());
        usuarioResponse.setCreated(newUserDto.getCreated());
        usuarioResponse.setIsactive(newUserDto.isIsactive());
        usuarioResponse.setModified(newUserDto.getModified());
        usuarioResponse.setToken(newUserDto.getToken());
        return usuarioResponse;
    }
}
