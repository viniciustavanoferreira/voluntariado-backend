package com.bomvizinho.microservice.infrastructure.dataprovider.repository;

import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntarioRepository extends JpaRepository<Voluntario, Long> {

    Voluntario findByUsuarioVoluntario_IdUsuario(String idUsuario);

}
