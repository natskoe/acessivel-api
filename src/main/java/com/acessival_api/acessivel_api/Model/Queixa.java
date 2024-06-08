package com.acessival_api.acessivel_api.Model;


import lombok.Data;

@Data
public class Queixa extends Solicitacao {

    private String imagem_link;

    public Queixa(String titulo, String descricao, String local, Queixante queixante, boolean status, String imagemLink) {
        super(titulo, descricao, local, queixante, status);
        this.imagem_link = imagemLink;
    }
}
