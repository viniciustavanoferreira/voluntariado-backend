package com.bomvizinho.microservice.boundary.controller;

import com.bomvizinho.microservice.application.service.EmailService;
import com.bomvizinho.microservice.application.usecase.*;
import com.bomvizinho.microservice.boundary.controller.dto.request.IdosoRequestDTO;
import com.bomvizinho.microservice.boundary.controller.dto.request.UsuarioRequestDTO;
import com.bomvizinho.microservice.boundary.controller.dto.request.VoluntarioRequestDTO;
import com.bomvizinho.microservice.boundary.controller.dto.response.login.LoginResponseDTO;
import com.bomvizinho.microservice.boundary.controller.dto.response.login.MessageResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/usuario")
public class UsuarioController {

    private final EmailService emailService;
    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;
    private final LoginUseCase loginUseCase;
    private final AlterarSenhaUseCase alterarSenhaUseCase;
    private final AlterarVoluntarioUseCase alterarVoluntarioUseCase;
    private final AlterarIdosoUseCase alterarIdosoUseCase;

    public UsuarioController(CadastrarUsuarioUseCase cadastrarUsuarioUseCase,
                             EmailService emailService,
                             LoginUseCase loginUseCase,
                             AlterarSenhaUseCase alterarSenhaUseCase,
                             AlterarVoluntarioUseCase alterarVoluntarioUseCase,
                             AlterarIdosoUseCase alterarIdosoUseCase) {
        this.cadastrarUsuarioUseCase = cadastrarUsuarioUseCase;
        this.emailService = emailService;
        this.loginUseCase = loginUseCase;
        this.alterarSenhaUseCase = alterarSenhaUseCase;
        this.alterarVoluntarioUseCase = alterarVoluntarioUseCase;
        this.alterarIdosoUseCase = alterarIdosoUseCase;
    }

    @PostMapping("login/id-usuario/{id-usuario}/senha/{senha}")
    @Operation(summary = "Login (retorna todos os dados vinculados ao usuário)")
    public ResponseEntity<LoginResponseDTO> login(@PathVariable("id-usuario") String idUsuario, @PathVariable("senha") String senha) {
        return ResponseEntity.ok(loginUseCase.execute(idUsuario, senha));
    }

    @PostMapping
    @Operation(summary = "Cadastrar usuário")
    public ResponseEntity<MessageResponseDTO> cadastrarUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        cadastrarUsuarioUseCase.execute(usuarioRequestDTO);
        return ResponseEntity.ok(MessageResponseDTO.Builder
                .aMessageDTO()
                    .withMessage("Usuario cadastrado com sucesso!")
                .build());
    }

    @PutMapping("/voluntario")
    @Operation(summary = "Alterar voluntário (dados específicos e gerais)")
    public ResponseEntity<MessageResponseDTO> alterarVoluntario(@RequestBody VoluntarioRequestDTO voluntarioRequestDTO) {
        alterarVoluntarioUseCase.execute(voluntarioRequestDTO);
        return ResponseEntity.ok(MessageResponseDTO.Builder
                .aMessageDTO()
                    .withMessage("Voluntario alterado com sucesso!")
                .build());
    }

    @PutMapping("/idoso")
    @Operation(summary = "Alterar idoso (dados específicos e gerais)")
    public ResponseEntity<MessageResponseDTO> alterarIdoso(@RequestBody IdosoRequestDTO idosoRequestDTO) {
        alterarIdosoUseCase.execute(idosoRequestDTO);
        return ResponseEntity.ok(MessageResponseDTO.Builder
                .aMessageDTO()
                    .withMessage("Idoso alterado com sucesso!")
                .build());
    }

    @PostMapping("/redefinir-senha/email/{email}")
    @Operation(summary = "Refinir senha (envia e-mail para usuário alterar senha)")
    public ResponseEntity<MessageResponseDTO> redefinirSenha(@PathVariable("email") String email) {
        emailService.sendEmail(email);
        return ResponseEntity.ok(MessageResponseDTO.Builder
                .aMessageDTO()
                    .withMessage("E-mail para redefinir a senha foi enviado com sucesso!")
                .build());
    }

    @PostMapping("/alterar-senha/id-usuario/{id-usuario}/nova-senha/{nova-senha}")
    @Operation(summary = "Alterar senha (definição da nova senha informada pelo usuário)")
    public ResponseEntity<MessageResponseDTO> alterarSenha(@PathVariable("id-usuario") String idUsuario,
                                                           @PathVariable("nova-senha") String novaSenha) {
        alterarSenhaUseCase.execute(idUsuario, novaSenha);
        return ResponseEntity.ok(MessageResponseDTO.Builder
                .aMessageDTO()
                    .withMessage("Senha alterada com sucesso!")
                .build());
    }

}