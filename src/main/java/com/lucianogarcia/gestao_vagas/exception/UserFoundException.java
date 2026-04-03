package com.lucianogarcia.gestao_vagas.exception;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("Usuário já existe!");
    }
}
