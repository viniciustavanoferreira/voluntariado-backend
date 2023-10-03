package com.bomvizinho.microservice.infrastructure.dataprovider.repository;

import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByEmail(String email);

}
