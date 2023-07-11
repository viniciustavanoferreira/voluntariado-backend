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

    @PostMapping(path = { "login/idoso/email/{email}/password/{password}" })
    public ResponseEntity<IdosoDTO> loginIdoso(@PathVariable("email") String email, @PathVariable("password") String password) {
        //usuarioService.adicionarUsuario(email, password);
        //usuarioService.consultarUsuario(email, password);
        return ResponseEntity.ok(new IdosoDTO());
    }

    @PostMapping(path = { "login/voluntario/email/{email}/password/{password}" })
    public ResponseEntity<VoluntarioDTO> loginVoluntario(@PathVariable("email") String email, @PathVariable("password") String password) {
        //usuarioService.adicionarUsuario(email, password);
        //usuarioService.consultarUsuario(email, password);
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

    @DeleteMapping(path = { "/idoso/{email}" })
    public ResponseEntity<String> deletarIdoso(@PathVariable("email") String email) {
        //idosoService.deletarIdoso(idosoDTO);
        //usuarioService.deletarUsuarioIdoso(idosoDTO.getUsuario(), idosoDTO.getSenha());
        return ResponseEntity.ok("Idoso deletado com sucesso!");
    }

    @GetMapping(path = { "/idoso/{email}" })
    public ResponseEntity<String> buscarIdoso(@PathVariable("email") String email) {
        //idosoService.buscarIdoso(email);
        return ResponseEntity.ok("Idoso selecionado com sucesso!");
    }

    @PostMapping(path = { "/voluntario" })
    public ResponseEntity<String> cadastrarVoluntario(@RequestBody VoluntarioDTO voluntarioDTO) {
        //voluntarioService.adicionarVoluntario(idosoDTO);
        //usuarioService.adicionarUsuarioVoluntario(voluntarioDTO.getUsuario(), voluntarioDTO.getSenha());
        return ResponseEntity.ok("Voluntário cadastrado com sucesso!");
    }

    @PutMapping(path = { "/voluntario" })
    public ResponseEntity<String> atualizarVoluntario(@RequestBody VoluntarioDTO voluntarioDTO) {
        return ResponseEntity.ok("Voluntário atualizado com sucesso!");
    }

    @DeleteMapping(path = { "/voluntario/{email}" })
    public ResponseEntity<String> deletarVoluntario(@PathVariable("email") String email) {
        //voluntarioService.deletarVoluntario(usuario);
        //usuarioService.deletarUsuarioVoluntario(idosoDTO.getUsuario(), idosoDTO.getSenha());
        return ResponseEntity.ok("Voluntário deletado com sucesso!");
    }

    @GetMapping(path = { "/voluntario/{email}" })
    public ResponseEntity<String> buscarVoluntario(@PathVariable("email") String email) {
        //voluntarioService.buscarIdoso(email);
        return ResponseEntity.ok("Voluntario selecionado com sucesso!");
    }

}