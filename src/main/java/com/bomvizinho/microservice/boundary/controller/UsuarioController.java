package com.bomvizinho.microservice.boundary.controller;

import com.bomvizinho.microservice.application.service.EmailService;
import com.bomvizinho.microservice.application.usecase.AlterarSenhaUseCase;
import com.bomvizinho.microservice.application.usecase.CadastrarUsuarioUseCase;
import com.bomvizinho.microservice.application.usecase.LoginUseCase;
import com.bomvizinho.microservice.boundary.controller.dto.request.UsuarioDTO;
import com.bomvizinho.microservice.boundary.controller.dto.response.login.LoginResponseDTO;
import com.bomvizinho.microservice.boundary.controller.dto.response.login.MessageResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/usuario")
public class UsuarioController {

    private final EmailService emailService;
    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;
    private final LoginUseCase loginUseCase;
    private final AlterarSenhaUseCase alterarSenhaUseCase;

    public UsuarioController(CadastrarUsuarioUseCase cadastrarUsuarioUseCase,
                             EmailService emailService,
                             LoginUseCase loginUseCase,
                             AlterarSenhaUseCase alterarSenhaUseCase) {
        this.cadastrarUsuarioUseCase = cadastrarUsuarioUseCase;
        this.emailService = emailService;
        this.loginUseCase = loginUseCase;
        this.alterarSenhaUseCase = alterarSenhaUseCase;
    }

    @PostMapping("login/email/{email}/password/{password}")
    public ResponseEntity<LoginResponseDTO> login(@PathVariable("email") String email, @PathVariable("password") String password) {
        return ResponseEntity.ok(loginUseCase.execute(email, password));
    }

    @PostMapping
    public ResponseEntity<MessageResponseDTO> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        cadastrarUsuarioUseCase.execute(usuarioDTO);
        return ResponseEntity.ok(MessageResponseDTO.Builder
                .aMessageDTO()
                    .withMessage("Usuário cadastrado com sucesso!")
                .build());
    }

    @PostMapping("/redefinir-senha/email/{email}")
    public ResponseEntity<String> redefinirSenha(@PathVariable("email") String email) {
        emailService.sendEmail(email);
        return ResponseEntity.ok("E-mail para redefinir a senha foi enviado com sucesso!");
    }

    @PostMapping("/alterar-senha/email/{email}/nova-senha/{nova-senha}")
    public ResponseEntity<MessageResponseDTO> alterarSenha(@PathVariable("email") String email,
                                                           @PathVariable("nova-senha") String novaSenha) {
        alterarSenhaUseCase.execute(email, novaSenha);
        return ResponseEntity.ok(MessageResponseDTO.Builder
                .aMessageDTO()
                    .withMessage("Senha alterada com sucesso!")
                .build());
    }

}