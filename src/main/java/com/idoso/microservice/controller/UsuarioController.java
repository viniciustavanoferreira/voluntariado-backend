package com.idoso.microservice.controller;

import com.idoso.microservice.dto.IdosoDTO;
import com.idoso.microservice.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(path = { "/login/username/{username}/password/{password}" })
    public String login(@PathVariable("username") String username, @PathVariable("password") String password) {
        //usuarioService.adicionarUsuario(username, password);
        //usuarioService.consultarUsuario(username, password);
        return "Usuário existe!";
    }

    @PostMapping(path = { "/idoso" })
    public String cadastrarIdoso(@RequestBody IdosoDTO idosoDTO) {
        //idosoService.adicionarIdoso(idosoDTO);
        //usuarioService.adicionarUsuarioIdoso(idosoDTO.getUsuario(), idosoDTO.getSenha());
        return "Idoso cadastrado com sucesso!";
    }

    @DeleteMapping(path = { "/idoso/{idosoId}" })
    public String deletarIdoso(@PathVariable("idosoId") String idosoId) {
        //idosoService.deletarIdoso(idosoDTO);
        //usuarioService.deletarUsuarioIdoso(idosoDTO.getUsuario(), idosoDTO.getSenha());
        return "Idoso deletado com sucesso!";
    }

    @PostMapping(path = { "/voluntario" })
    public String cadastrarVoluntario(@RequestBody IdosoDTO idosoDTO) {
        //idosoService.adicionarVoluntario(idosoDTO);
        //usuarioService.adicionarUsuarioVoluntario(idosoDTO.getUsuario(), idosoDTO.getSenha());
        return "Voluntário cadastrado com sucesso!";
    }

    @DeleteMapping(path = { "/voluntario/{voluntarioId}" })
    public String deletarVoluntario(@PathVariable("voluntarioId") String voluntarioId) {
        //idosoService.deletarVoluntario(idosoDTO);
        //usuarioService.deletarUsuarioVoluntario(idosoDTO.getUsuario(), idosoDTO.getSenha());
        return "Voluntário deletado com sucesso!";
    }

}