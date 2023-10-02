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

    @ExceptionHandler({CriarUsuarioException.class})
    public ResponseEntity<Object> handleCriarUsuarioException(CriarUsuarioException ex, WebRequest request) {
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
