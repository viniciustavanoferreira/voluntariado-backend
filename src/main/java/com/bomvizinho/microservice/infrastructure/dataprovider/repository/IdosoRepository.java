package com.bomvizinho.microservice.infrastructure.dataprovider.repository;

import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Idoso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdosoRepository extends JpaRepository<Idoso, Long> {

    Idoso findByUsuarioIdoso_IdUsuario(String idUsuario);

}
