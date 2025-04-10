package com.usuarios.usuarios.repository;

import com.usuarios.usuarios.dto.UsuarioDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface UsuariosRepository extends JpaRepository<UsuarioDto, Long> {
}
