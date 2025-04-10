package com.usuarios.usuarios.repository;

import com.usuarios.usuarios.dto.ConfigDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface ConfigRepository  extends JpaRepository<ConfigDto, Long> {

}
