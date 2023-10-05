package com.bomvizinho.microservice.infrastructure.exception;

import com.bomvizinho.microservice.application.exception.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class SistemaVoluntariadoExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({CadastrarUsuarioException.class})
    public ResponseEntity<Object> handleCadastrarUsuarioException(CadastrarUsuarioException ex, WebRequest request) {
        return handleExceptionInternal(ex, new Error("Cadastrar usuario", ex.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({BuscarUsuarioException.class})
    public ResponseEntity<Object> handleBuscarUsuarioException(BuscarUsuarioException ex, WebRequest request) {
        return handleExceptionInternal(ex, new Error("Buscar usuario", ex.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({CriarOuAlterarUsuarioException.class})
    public ResponseEntity<Object> handleCriarUsuarioException(CriarOuAlterarUsuarioException ex, WebRequest request) {
        return handleExceptionInternal(ex, new Error("Criar usuario", ex.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({LoginException.class})
    public ResponseEntity<Object> handleLoginException(LoginException ex, WebRequest request) {
        return handleExceptionInternal(ex, new Error("Login", ex.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({AlterarSenhaException.class})
    public ResponseEntity<Object> handleAlterarSenhaException(AlterarSenhaException ex, WebRequest request) {
        return handleExceptionInternal(ex, new Error("Alterar senha", ex.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({BuscarVoluntarioException.class})
    public ResponseEntity<Object> handleBuscarVoluntarioException(BuscarVoluntarioException ex, WebRequest request) {
        return handleExceptionInternal(ex, new Error("Buscar voluntario", ex.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({AlterarVoluntarioException.class})
    public ResponseEntity<Object> handleAlterarVoluntarioException(AlterarVoluntarioException ex, WebRequest request) {
        return handleExceptionInternal(ex, new Error("Alterar voluntario", ex.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({CriarOuAlterarVoluntarioException.class})
    public ResponseEntity<Object> handleCriarOuAlterarVoluntarioException(CriarOuAlterarVoluntarioException ex, WebRequest request) {
        return handleExceptionInternal(ex, new Error("Criar ou alterar voluntario", ex.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({BuscarIdosoException.class})
    public ResponseEntity<Object> handleBuscarIdosoException(BuscarIdosoException ex, WebRequest request) {
        return handleExceptionInternal(ex, new Error("Buscar idoso", ex.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({AlterarIdosoException.class})
    public ResponseEntity<Object> handleAlterarIdosoException(AlterarIdosoException ex, WebRequest request) {
        return handleExceptionInternal(ex, new Error("Alterar idoso", ex.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({CriarOuAlterarIdosoException.class})
    public ResponseEntity<Object> handleCriarOuAlterarIdosoException(CriarOuAlterarVoluntarioException ex, WebRequest request) {
        return handleExceptionInternal(ex, new Error("Criar ou alterar idoso", ex.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({BuscarServicoException.class})
    public ResponseEntity<Object> handleBuscarServicoException(BuscarServicoException ex, WebRequest request) {
        return handleExceptionInternal(ex, new Error("Buscar servico", ex.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({ManterServicoException.class})
    public ResponseEntity<Object> handleManterServicoException(ManterServicoException ex, WebRequest request) {
        return handleExceptionInternal(ex, new Error("Manter servico", ex.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({DeletarServicoException.class})
    public ResponseEntity<Object> handleDeletarServicoException(DeletarServicoException ex, WebRequest request) {
        return handleExceptionInternal(ex, new Error("Manter servico", ex.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({CriarOuAlterarServicoException.class})
    public ResponseEntity<Object> handleCriarOuAlterarServicoException(CriarOuAlterarServicoException ex, WebRequest request) {
        return handleExceptionInternal(ex, new Error("Criar ou alterar servico", ex.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({CriarServicoException.class})
    public ResponseEntity<Object> handleCriarServicoException(CriarServicoException ex, WebRequest request) {
        return handleExceptionInternal(ex, new Error("Criar servico", ex.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    public static class Error {
        private final String message;
        private final String exception;

        public Error(String message, String exception) {
            this.message = message;
            this.exception = exception;
        }

        public String getMessage() {
            return message;
        }

        public String getException() {
            return exception;
        }
    }

}
