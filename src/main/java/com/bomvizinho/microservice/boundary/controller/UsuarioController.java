package com.bomvizinho.microservice.boundary.controller;

import com.bomvizinho.microservice.application.usecase.CadastrarUsuarioUseCase;
import com.bomvizinho.microservice.boundary.controller.dto.login.UsuarioDTO;
import com.bomvizinho.microservice.boundary.controller.dto.response.MessageDTO;
import com.bomvizinho.microservice.boundary.controller.dto.servico.idoso.IdosoDTO;
import com.bomvizinho.microservice.boundary.controller.dto.servico.voluntario.VoluntarioDTO;
import com.bomvizinho.microservice.application.service.EmailService;
import com.bomvizinho.microservice.application.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/usuario")
public class UsuarioController {

    private final EmailService emailService;
    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;

    public UsuarioController(CadastrarUsuarioUseCase cadastrarUsuarioUseCase,
                             EmailService emailService) {
        this.cadastrarUsuarioUseCase = cadastrarUsuarioUseCase;
        this.emailService = emailService;
    }

    @PostMapping("login/email/{email}/password/{password}")
    public ResponseEntity<UsuarioDTO> login(@PathVariable("email") String email, @PathVariable("password") String password) {
        //usuarioService.adicionarUsuario(email, password);
        //usuarioService.consultarUsuario(email, password);
        return ResponseEntity.ok(UsuarioDTO.Builder
                .anUsuarioDTO()
                    .withEmail("vinicius-titio@etec.sp.gov.br")
                    .withPerfil("VOLUNTARIO")
                    .withCep("99999-999")
                    .withEndereco("Rua das Flores, 123")
                    .withNome("Vini Titio")
                    .withDataNascimento("01/01/1940")
                    .withUsuario("vinicius-titio")
                    .withTelefone("17-99999-9999")
                .build());
    }

    @PostMapping
    public ResponseEntity<MessageDTO> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        cadastrarUsuarioUseCase.execute(usuarioDTO);
        return ResponseEntity.ok(MessageDTO.Builder
                .aMessageDTO()
                    .withMessage("Usuário cadastrado com sucesso!")
                .build());
    }

    @PostMapping("/idoso")
    public ResponseEntity<String> cadastrarIdoso(@RequestBody IdosoDTO idosoDTO) {
        //idosoService.adicionarIdoso(idosoDTO);
        //usuarioService.adicionarUsuarioIdoso(idosoDTO.getUsuario(), idosoDTO.getSenha());
        return ResponseEntity.ok("Idoso cadastrado com sucesso!");
    }

    @PutMapping("/idoso")
    public ResponseEntity<String> atualizarIdoso(@RequestBody IdosoDTO idosoDTO) {
        return ResponseEntity.ok("Idoso atualizado com sucesso!");
    }

    @DeleteMapping("/idoso/email/{email}")
    public ResponseEntity<String> deletarIdoso(@PathVariable("email") String email) {
        //idosoService.deletarIdoso(idosoDTO);
        //usuarioService.deletarUsuarioIdoso(idosoDTO.getUsuario(), idosoDTO.getSenha());
        return ResponseEntity.ok("Idoso deletado com sucesso!");
    }

    @GetMapping("/idoso/email/{email}")
    public ResponseEntity<String> buscarIdoso(@PathVariable("email") String email) {
        //idosoService.buscarIdoso(email);
        return ResponseEntity.ok("Idoso selecionado com sucesso!");
    }

    @PostMapping("/voluntario")
    public ResponseEntity<String> cadastrarVoluntario(@RequestBody VoluntarioDTO voluntarioDTO) {
        //voluntarioService.adicionarVoluntario(idosoDTO);
        //usuarioService.adicionarUsuarioVoluntario(voluntarioDTO.getUsuario(), voluntarioDTO.getSenha());
        return ResponseEntity.ok("Voluntário cadastrado com sucesso!");
    }

    @PutMapping("/voluntario")
    public ResponseEntity<String> atualizarVoluntario(@RequestBody VoluntarioDTO voluntarioDTO) {
        return ResponseEntity.ok("Voluntário atualizado com sucesso!");
    }

    @DeleteMapping("/voluntario/email/{email}")
    public ResponseEntity<String> deletarVoluntario(@PathVariable("email") String email) {
        //voluntarioService.deletarVoluntario(usuario);
        //usuarioService.deletarUsuarioVoluntario(idosoDTO.getUsuario(), idosoDTO.getSenha());
        return ResponseEntity.ok("Voluntário deletado com sucesso!");
    }

    @GetMapping("/voluntario/email/{email}")
    public ResponseEntity<String> buscarVoluntario(@PathVariable("email") String email) {
        //voluntarioService.buscarIdoso(email);
        return ResponseEntity.ok("Voluntario selecionado com sucesso!");
    }

    @PostMapping("/redefinir-senha/email/{email}")
    public ResponseEntity<String> redefinirSenha(@PathVariable("email") String email) {
        emailService.sendEmail(email);
        return ResponseEntity.ok("E-mail para redefinir a senha foi enviado com sucesso!");
    }

    @PostMapping("/alterar-senha/email/{email}/nova-senha/{nova-senha}")
    public ResponseEntity<String> alterarSenha(@PathVariable("email") String email,
                                               @PathVariable("nova-senha") String novaSenha) {
        return ResponseEntity.ok("Senha alterada com sucesso!");
    }

}