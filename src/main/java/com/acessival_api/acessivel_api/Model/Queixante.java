package com.acessival_api.acessivel_api.Model;

import lombok.Data;

@Data
public class Queixante extends Usuario{

    private String cadPcd;
    private Endereco endereco;

    public Queixante(String senha, String nome, String sobrenome, String email, String cpf, String cadPcd, Endereco endereco) {
        super(senha, nome, sobrenome, email, cpf);
        this.cadPcd = cadPcd;
        this.endereco = endereco;
    }
}
