package com.bomvizinho.microservice.application.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value(value = "${url.sistema-bomvizinho.alterar.senha}")
    private String urlSistemaAlterarSenha;

    private JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Redefinir senha");
        message.setText("Para redefinir sua senha, utilize o seguinte link: " +
                urlSistemaAlterarSenha);

        mailSender.send(message);
    }

}
