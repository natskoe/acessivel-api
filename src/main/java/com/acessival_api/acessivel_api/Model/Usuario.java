package com.acessival_api.acessivel_api.Model;

import lombok.Data;

import java.net.PasswordAuthentication;
import java.util.Date;

@Data
public class Usuario {

    private String senha;
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;

    public Usuario(String senha, String nome, String sobrenome, String email, String cpf) {
        this.senha = senha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cpf = cpf;
    }

}
