package com.bomvizinho.microservice.infrastructure.dataprovider.repository;

import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM usuario " +
                        "WHERE email = :email", nativeQuery = true)
    List<Usuario> getUsuarioByEmail(@Param("email") String email);

}
