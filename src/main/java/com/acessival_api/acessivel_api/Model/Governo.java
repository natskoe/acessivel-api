package com.acessival_api.acessivel_api.Model;

import lombok.Data;

import java.util.Date;

@Data
public class Governo extends Usuario{

    private String matricula;

    public Governo(String senha, String nome, String sobrenome, String email, String cpf, String matricula) {
        super(senha, nome, sobrenome, email, cpf);
        this.matricula = matricula;
    }
}
