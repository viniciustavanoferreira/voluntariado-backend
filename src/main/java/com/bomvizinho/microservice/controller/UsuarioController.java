package com.bomvizinho.microservice.controller;

import com.bomvizinho.microservice.dto.IdosoDTO;
import com.bomvizinho.microservice.dto.VoluntarioDTO;
import com.bomvizinho.microservice.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(path = { "login/idoso/username/{username}/password/{password}" })
    public ResponseEntity<IdosoDTO> loginIdoso(@PathVariable("username") String username, @PathVariable("password") String password) {
        //usuarioService.adicionarUsuario(username, password);
        //usuarioService.consultarUsuario(username, password);
        return ResponseEntity.ok(new IdosoDTO());
    }

    @PostMapping(path = { "login/voluntario/username/{username}/password/{password}" })
    public ResponseEntity<VoluntarioDTO> loginVoluntario(@PathVariable("username") String username, @PathVariable("password") String password) {
        //usuarioService.adicionarUsuario(username, password);
        //usuarioService.consultarUsuario(username, password);
        return ResponseEntity.ok(new VoluntarioDTO());
    }

    @PostMapping(path = { "/idoso" })
    public ResponseEntity<String> cadastrarIdoso(@RequestBody IdosoDTO idosoDTO) {
        //idosoService.adicionarIdoso(idosoDTO);
        //usuarioService.adicionarUsuarioIdoso(idosoDTO.getUsuario(), idosoDTO.getSenha());
        return ResponseEntity.ok("Idoso cadastrado com sucesso!");
    }

    @PutMapping(path = { "/idoso" })
    public ResponseEntity<String> atualizarIdoso(@RequestBody IdosoDTO idosoDTO) {
        return ResponseEntity.ok("Idoso atualizado com sucesso!");
    }

    @DeleteMapping(path = { "/idoso/{usuario}" })
    public ResponseEntity<String> deletarIdoso(@PathVariable("usuario") String usuario) {
        //idosoService.deletarIdoso(idosoDTO);
        //usuarioService.deletarUsuarioIdoso(idosoDTO.getUsuario(), idosoDTO.getSenha());
        return ResponseEntity.ok("Idoso deletado com sucesso!");
    }

    @PostMapping(path = { "/voluntario" })
    public ResponseEntity<String> cadastrarVoluntario(@RequestBody VoluntarioDTO voluntarioDTO) {
        //idosoService.adicionarVoluntario(idosoDTO);
        //usuarioService.adicionarUsuarioVoluntario(idosoDTO.getUsuario(), idosoDTO.getSenha());
        return ResponseEntity.ok("Voluntário cadastrado com sucesso!");
    }

    @PutMapping(path = { "/voluntario" })
    public ResponseEntity<String> atualizarVoluntario(@RequestBody VoluntarioDTO voluntarioDTO) {
        return ResponseEntity.ok("Voluntário atualizado com sucesso!");
    }

    @DeleteMapping(path = { "/voluntario/{usuario}" })
    public ResponseEntity<String> deletarVoluntario(@PathVariable("usuario") String usuario) {
        //idosoService.deletarVoluntario(usuario);
        //usuarioService.deletarUsuarioVoluntario(idosoDTO.getUsuario(), idosoDTO.getSenha());
        return ResponseEntity.ok("Voluntário deletado com sucesso!");
    }

}