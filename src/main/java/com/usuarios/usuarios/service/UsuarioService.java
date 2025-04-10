package com.usuarios.usuarios.service;

import com.usuarios.usuarios.Exception.UsuarioException;
import com.usuarios.usuarios.request.UsuarioRequest;
import com.usuarios.usuarios.response.UsuarioResponse;

public interface UsuarioService{
    UsuarioResponse createUser(UsuarioRequest usuarioRequest) throws UsuarioException;
}
